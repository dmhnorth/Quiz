package controllers;

/**
 * For users who connect to a QuizServerLauncher to enable them
 * to carry out the operations associated with
 * choosing and playing quizzes, along with
 * retrieving data about the QuizServerModel
 *
 * Constructed with a model (Server side) and with a view (on the Client side)
 *
 */
public interface PlayerClientController { //needs to implement QuizServerController methods


    /**
     * Launches the user interface of the controllers.PlayerClientController
     */
    public void start();
}
