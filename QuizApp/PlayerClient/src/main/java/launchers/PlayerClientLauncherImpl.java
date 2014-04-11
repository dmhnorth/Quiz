package launchers;

import controllers.PlayerClientController;
import controllers.PlayerClientControllerImpl;
import controllers.QuizServerController;
import views.PlayerClientView;
import views.PlayerClientViewImpl;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PlayerClientLauncherImpl implements PlayerClientLauncher {

    private QuizServerController quizServerController;

    public static void main(String[] args) {
        PlayerClientLauncher launcher = new PlayerClientLauncherImpl();
        launcher.launch();
    }

    public void launch() {

        Registry registry = null;
        try {
            System.setSecurityManager(new RMISecurityManager());
            registry = LocateRegistry.getRegistry(1098);

            quizServerController = (QuizServerController) registry.lookup("quizServerController");

        } catch (Exception e) {
            System.out.println("Could not connect to a 'quizServerController' object on the server side. Exeception: " + e);
        }

        //MOVE THIS LOT INTO THE TRY BLOCK ABOVE ONCE FINISHED
        //Starts the controllers.controllers.PlayerClientController once the launcher has found the link

        try {
            PlayerClientView playerClientView = new PlayerClientViewImpl();

            PlayerClientController playerClientController = new PlayerClientControllerImpl(quizServerController, playerClientView);


        }
    }
}
