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

//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager()); }

//        File file = new File("QuizServer/security.policy");
//        System.out.println(file.exists());



        try {

                if (dm.dataFileExists()){
                    quizServerModel = dm.loadData();
                    System.out.println("Data was loaded from 'quizdata.txt' file.");
                } else {
                    quizServerModel = new QuizServerModelImpl();
                    System.out.println("New quizdata.txt will be created.");
                }
                Runtime.getRuntime().addShutdownHook(saveOnExit());

            QuizServerController quizServerController = new QuizServerControllerImpl(quizServerModel);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("quizServerController", quizServerController);

            System.out.println("Quiz Server is ready");

            System.out.println("Quizzes on this server: ");
            quizServerModel.testPrintContainer();

        }catch (Exception e) {
            System.out.println("The Quiz Server failed: " + e);
            e.printStackTrace();
        }
    }



    /**
     * Saves the state of the QuizServerModel on exit
     *
     * @return a thread for the shutdown process to carry out
     */
    private Thread saveOnExit(){

        return new Thread(() -> flush());
    }

    public void flush() {
        dm.saveData(quizServerModel);
    }

}