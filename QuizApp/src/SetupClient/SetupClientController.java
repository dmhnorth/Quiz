package SetupClient;

import QuizServer.Assets.Question;

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
    void createAQuiz();

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
    Question createAQuestion();


    /**
     * PrettyPrint the quizzes on the current server the SetupClientController is connected to
     */
    void printActiveQuizzes();
}
