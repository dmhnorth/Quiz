package launchers;

import controllers.SetupClientController;
import controllers.SetupClientControllerImpl;
import views.SetupClientView;
import views.SetupClientViewImpl;

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

        Registry registry = null;
        try {
            System.setSecurityManager(new RMISecurityManager());
            registry = LocateRegistry.getRegistry(1098);

            quizServerController = (QuizServerController) registry.lookup("quizServerController");

        } catch (Exception e) {
            System.out.println("Could not connect to a 'quizServerController' object on the server side. Exception: " + e);
        }


        //MOVE THIS LOT INTO THE TRY BLOCK ABOVE ONCE FINISHED
        //Starts the controllers.SetupClientController once the launcher has found the link

        try {
            SetupClientView setupClientView = new SetupClientViewImpl();

            SetupClientController setupClientController = new SetupClientControllerImpl(quizServerController, setupClientView);

            setupClientController.start();

            if(quizServerController != null) {
                assert registry != null;
                registry.unbind("quizServerController");
                System.out.println("NOTE:the quizServerController object has been unbound.");
            } else {
                System.out.println("(NOTE:There was no Server to unbind)");
            }

        } catch (Exception e){
            System.out.println("Something went wrong starting the SetupClient...");
        }


    }
}