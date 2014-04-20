package models;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The class that contains the entirety of a quiz
 */
public interface Quiz extends Remote {

    /**
     * Returns the quiz author
     * @return the author
     * @throws java.rmi.RemoteException
     */
    String getQuizAuthor() throws RemoteException;

    /**
     * Gives the name of the quiz
     * @return the quiz name
     * @throws java.rmi.RemoteException
     */
    String getQuizName() throws RemoteException;

    /**
     * gives the ID of a quiz
     * @return an id unique to a QuizServerModel
     * @throws java.rmi.RemoteException
     */
    int getQuizId() throws RemoteException;

    /**
     * For setting the high score of a quiz after it has been played
     * @param highScore the current high score
     * @throws java.rmi.RemoteException
     */
    void setHighScore(int highScore) throws RemoteException;

    /**
     * For returning the high score
     * @return high score of this quiz
     * @throws java.rmi.RemoteException
     */
    int getHighScore() throws RemoteException;

    /**
     * For setting the highest scoring player on this quiz, the current ranking leadr
     * @param highScoreHolder current winner
     * @throws java.rmi.RemoteException
     */
    void setHighScoreHolder(String highScoreHolder) throws RemoteException;

    /**
     * For returning the current highscore holder on this quiz
     * @return current quiz highscore holder
     * @throws java.rmi.RemoteException
     */
    String getHighScoreHolder() throws RemoteException;

    /**
     * Gives the questions set within this quiz
     * @return the questions
     * @throws java.rmi.RemoteException
     */
    String[][] getQuestions() throws RemoteException;

    /**
     * Quiz locks, to be used when editing a quiz only so other players cannot play a quiz currently being edited
     * @return whether the quiz is currently locked
     * @throws java.rmi.RemoteException
     */
    boolean isQuizLocked() throws RemoteException;

    /**
     * Lock a quiz so it can be edited without fear that other players may try to access it
     * @throws java.rmi.RemoteException
     */
    void lockQuiz() throws RemoteException;

    /**
     * unlock a quiz once editing is complete
     * @throws java.rmi.RemoteException
     */
    void unlockQuiz() throws RemoteException;

    /**
     * Returns all the main details of a quiz in a simple format for printing on screen
     * @return quiz id, name and high score details
     * @throws java.rmi.RemoteException
     */
    String quizDetailsToString() throws RemoteException;
}
