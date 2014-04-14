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


    private QuizServerController quizServerController;
    DataManager dm = new DataManagerImpl();
    QuizServerModel quizServerModel;




    public static void main(String[] args) throws RemoteException {

            QuizServerLauncher launcher = new QuizServerLauncherImpl();
            launcher.launch();

            }

    @Override
    public void launch() throws RemoteException {



        try {

                if (dm.dataFileExists()){
                    quizServerModel = dm.loadData();
                } else {
                    quizServerModel = new QuizServerModelImpl();
                }
                Runtime.getRuntime().addShutdownHook(saveOnExit());


            quizServerController = new QuizServerControllerImpl(quizServerModel);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("quizServerController", quizServerController);

            System.out.println("Quiz Server is ready");
        }catch (Exception e) {
            System.out.println("The Quiz Server failed: " + e);
        }
        flush();
    }


    public void flush() {
        dm.saveData(quizServerModel);
    }

    /**
     * Saves the state of the QuizServerModel on exit
     *
     * @return a thread for the shutdown process to carry out
     */
    private Thread saveOnExit(){

        Thread exit = new Thread(new Runnable() {

            @Override
            public void run() {
                flush();
            }
        });
        return exit;
    }

}