package launchers;

import controllers.PlayerClientController;
import controllers.PlayerClientControllerImpl;
import controllers.QuizServerController;
import views.PlayerClientView;
import views.PlayerClientViewImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PlayerClientLauncherImpl implements PlayerClientLauncher {

    public static void main(String[] args) {
        PlayerClientLauncher launcher = new PlayerClientLauncherImpl();
        launcher.launch();
    }

    public void launch() {

        Registry registry;
        try {
            registry = LocateRegistry.getRegistry(1099);
            QuizServerController quizServerController = (QuizServerController) registry.lookup("quizServerController");

//CONNECTION AND SETUP
            try {
                PlayerClientView playerClientView = new PlayerClientViewImpl();
                PlayerClientController playerClientController = new PlayerClientControllerImpl(quizServerController, playerClientView);
                playerClientController.start();
            } catch (Exception e) {
                System.out.println("Something went wrong starting the SetupClient...");
            }
        } catch (Exception e) {
            System.out.println("Could not connect to a 'quizServerController' object on the server side. Exception: " + e);
        }
    }
}
