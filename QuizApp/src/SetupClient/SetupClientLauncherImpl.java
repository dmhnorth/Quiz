package SetupClient;

import QuizServer.QuizServerController;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SetupClientLauncherImpl implements SetupClientLauncher {


    private QuizServerController quizServerController;

    public static void main(String[] args) {

        SetupClientLauncher launcher = new SetupClientLauncherImpl();
        launcher.launch();
    }


    public void launch() {

        try {
            System.setSecurityManager(new RMISecurityManager());
            Registry registry = LocateRegistry.getRegistry(1098);

            quizServerController = (QuizServerController) registry.lookup("quizServerController");

        } catch (Exception e) {
            System.out.println("Could not connect to a 'quizServerController' object on the server side. Exception: " + e);
        }


        //MOVE THIS LOT INTO THE TRY BLOCK ABOVE.
        //Starts the SetupClientController once the launcher has found the link

        try {
            SetupClientView setupClientView = new SetupClientViewImpl();

            SetupClientController setupClientController = new SetupClientControllerImpl(quizServerController, setupClientView);

            setupClientController.start();

        } catch (Exception e){
            System.out.println("Something went wrong starting the SetupClient...");
        }


    }
}