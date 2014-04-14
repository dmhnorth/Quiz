package launchers;

import controllers.QuizServerController;
import models.QuizServerModel;

import java.rmi.RemoteException;

public class QuizServerLauncherImpl {

    public class QuizServerLauncherImpl implements QuizServerLauncher {

        private QuizServerController quizServerController;

        public static void main(String[] args) throws RemoteException {
            QuizServerLauncher launcher = new QuizServerLauncher() {
                @Override
                public void launch() throws RemoteException {

                }

                @Override
                public void tryLoadQuizServerModel(QuizServerModel qsm) {

                }
            };
            launcher.launch();

        }
    }
}
