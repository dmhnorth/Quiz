import models.QuizServerModel;

import java.rmi.RemoteException;

/**
 *
 * Has a main and Launches a Server
 *
 *
 */
public interface QuizServerLauncher{


    /**
     *
     * first looks up the Remote service, telling us if it can't find the server
     *
     * instantiates a QuizServerModel (First by trying to load an existing one)
     *
     * instantiates a QuizServerController and links it to the Model
     *
     * instantiates a QuizAssetFactory
     *
     * binds the QuizServerController to the registry for a client to connect
     *
     *
     */
    public void launch() throws RemoteException;

    /**
     * checks if there is a Quiz Model present on this server, if so, it loads and returns it
     * if not, it
     *
     * @return QuizServerModel
     * @return null if no model exists
     */
    public void tryLoadQuizServerModel(QuizServerModel qsm);
}



