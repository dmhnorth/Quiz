package SetupClient;

import QuizServer.QuizAssetFactory;
import QuizServer.QuizServerController;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SetupClientLauncherImpl implements SetupClientLauncher {


    private static final String SERVER = "//127.0.0.1:1098/quiz";
    private QuizServerController qServerController;

    public static void main(String[] args) {

        SetupClientLauncher launcher = new SetupClientLauncherImpl();
        launcher.launch();
    }


    public void launch() {

        try {
            System.setSecurityManager(new RMISecurityManager());
            Registry registry = LocateRegistry.getRegistry(1098);

            QuizServerController qServerController = (QuizServerController) registry.lookup("qServerController");



        } catch (Exception e) {
            System.out.println("Could not connect to 'QuizServerController'. Exception: " + e);
        }

        //MOVE THIS LOT INTO THE TRY BLOCK ABOVE.
        //Starts the SetupClientController once the launcher has found the link

        try {
            SetupClientView setupClientView = new SetupClientViewImpl();

            SetupClientController setupClientController = new SetupClientControllerImpl(qServerController, setupClientView);

            setupClientController.start();

        } catch (Exception e){
            System.out.println("Something went wrong starting the SetupClient...");
        }


    }
}