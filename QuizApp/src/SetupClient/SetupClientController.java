package SetupClient;

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
    public void start();

    /**
     * A user chooses what task they would like to carry out next
     */
    public void chooseTask();

    /**
     * Used to run the user through creating a quiz
     */
    public void createAQuiz();

    /**
     * PrettyPrint the quizzes on the current server the SetupClientController is connected to
     */
    public void printActiveQuizzes();
}
