package launchers;

import controllers.QuizServerController;
import controllers.QuizServerControllerImpl;
import models.QuizServerModel;
import models.QuizServerModelImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class QuizServerLauncherImpl implements QuizServerLauncher {


    private QuizServerController quizServerController;





    public static void main(String[] args) throws RemoteException {

            QuizServerLauncher launcher = new QuizServerLauncherImpl();
            launcher.launch();

            }

    @Override
    public void launch() throws RemoteException {

        try {


            QuizServerModel quizServerModel = new QuizServerModelImpl();
            quizServerModel = quizServerModel.tryLoadQuizServerModel();
            quizServerController = new QuizServerControllerImpl(quizServerModel);




            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("quizServerController", quizServerController);

            System.out.println("Quiz Server is ready");
        }catch (Exception e) {
            System.out.println("The Quiz Server failed: " + e);
        }

    }

}

