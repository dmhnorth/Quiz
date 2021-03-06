package launchers;

import java.rmi.RemoteException;

/**
 * Has a main and Launches a Server
 */
public interface QuizServerLauncher {


    /**
     * first looks up the Remote service, telling us if it can't find the server
     *
     * instantiates a QuizServerModel (First by trying to load an existing one)
     *
     * instantiates a QuizServerController and links it to the Model
     *
     * binds the QuizServerController to the registry for a client to connect
     */
    public void launch() throws RemoteException;

    void waitForShutDown();

    /**
     * Saves the QuizServerModel data when the program shuts down
     *
     *
     */
    void flush();
}



