package controllers;


import java.rmi.RemoteException;

/**
 * For users who connect to a Quiz Server and enable users
 * to carry out the operations associated with the setting up
 * and managing of quizzes within the QuizServerModel
 *
 */
public interface SetupClientController {   //needs to use QuizServerController methods


    /**
     * Starts the setup client program
     */
    void start();

    /**
     * A user chooses what task they would like to carry out next
     */
    void chooseTask();

    /**
     * Used to run the user through creating a quiz
     */
    int createAQuiz() throws RemoteException;

    /**
     * Get input for a quiz author name
     * @return String
     */
    String nameOfAuthor();

    /**
     * Get input for a quiz name
     * @return String
     */
    String nameOfQuiz();

    /**
     * Used to create a single question
     * @return Question created
     */
    String[] createAQuestion() throws RemoteException;

    /**
     * Used to create a set of Questions for the Quiz
     */
    String[][] createAQuestionSet() throws RemoteException;
}
