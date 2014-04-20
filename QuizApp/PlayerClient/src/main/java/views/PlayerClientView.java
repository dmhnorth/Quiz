package views;


import controllers.QuizServerController;
import models.Quiz;

import java.rmi.RemoteException;

/**
 * Class that creates the majority of terminal printouts for the player client
 */
public interface PlayerClientView {


    /**
     * Displays a welcome message
     */
    void displayWelcomeMessage();

    /**
     * displays a closing message
     */
    void thanksForUsingTheQuizSetupClient();

    /**
     * Displays the various options a user can choose to interact with the program
     */
    void displayUserOptions();

    /**
     * if a user has entered chosen something that doesn't exist, this message is displayed
     */
    void tryAgain();

    /**
     * Prints the currently active quizzes on the current server
     * @param quizServerController the quiz server that a user wants to view the quizzes from
     * @throws RemoteException
     */
    void printActiveQuizzes(QuizServerController quizServerController) throws RemoteException;

    /**
     * Introduction asking what quiz a person would like to see
     */
    void whatQuizWouldYouLikeToPlay();

    /**
     * displayed when someone enters something incorrectly
     */
    void inputError();

    /**
     * displays a list of the high scores and high score holders on a server
     * @param quizServerController the server the player wants to view information for
     * @throws RemoteException
     */
    void checkOutRankings(QuizServerController quizServerController) throws RemoteException;

    /**
     * Asks for an entry for a username from the player
     */
    void enterAUserName();

    /**
     * displays the information for the quiz a user is about to play
     * @param quiz the quiz details are required from
     * @throws RemoteException
     */
    void beginAQuiz(Quiz quiz) throws RemoteException;

    /**
     * prints the question to be asked, along with formatting the choices correctly for a user to make an option
     * @param qn
     * @throws RemoteException
     */
    void printAQuestionAndChoices(String[] qn) throws RemoteException;

    /**
     * Details for the submission of a score to the server
     * @param quiz the quiz detailed
     * @param score the score a user just achieved
     * @param playerName the name of the user who has just played
     * @throws RemoteException
     */
    void userScore(Quiz quiz, int score, String playerName) throws RemoteException;

    /**
     * Feedback of details after submitting a score to the server
     * @param quiz the quiz just played
     * @param score the latest score
     * @param playerName the name of the player
     * @throws RemoteException
     */
    void doYouHaveTheNewHighScore(Quiz quiz, int score, String playerName) throws RemoteException;
}
