package launchers;

import controllers.QuizServerController;
import controllers.QuizServerControllerImpl;
import models.QuizServerModel;
import models.QuizServerModelImpl;
import utilities.DataManager;
import utilities.DataManagerImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class QuizServerLauncherImpl implements QuizServerLauncher {


    DataManager dm = new DataManagerImpl();
    QuizServerModel quizServerModel;

    public static void main(String[] args) throws RemoteException {

        QuizServerLauncher launcher = new QuizServerLauncherImpl();
        launcher.launch();
    }

    @Override
    public void launch() throws RemoteException {

        System.setProperty("java.security.policy", "QuizServer/security.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {

            loadData();
            QuizServerController quizServerController = new QuizServerControllerImpl(quizServerModel);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("quizServerController", quizServerController);

            quizServerModel.printContainer();

        } catch (NullPointerException e) {
            System.out.println("Your Quiz Server Data was empty or corrupt. New Data will be created on shutdown.");
//            dm.deleteCorruptData();
        } catch (Exception e) {
            System.out.println("The Quiz Server failed: " + e);
        }
        waitForShutDown();
    }

    @Override
    public void waitForShutDown() {
        System.out.println("\nPress ENTER to shutdown the server.\n");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.exit(0);
    }

    /**
     * Loads persistent data, or creates a new one.
     * Adds the shutdown hook.
     */
    private void loadData() {
        if (dm.dataFileExists()) {
            quizServerModel = dm.loadData();
            System.out.println("Data was loaded from 'quizdata.txt' file.\n");
        } else {
            quizServerModel = new QuizServerModelImpl();
            System.out.println("New quizdata.txt will be created.\n");
        }
        Runtime.getRuntime().addShutdownHook(saveOnExit());
    }

    /**
     * Saves the state of the QuizServerModel on exit
     *
     * @return a thread for the shutdown process to carry out
     */
    private Thread saveOnExit() {

        return new Thread(() -> flush());
    }

    public void flush() {
        dm.saveData(quizServerModel);
    }
}