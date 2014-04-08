package QuizServer;

/**
 *
 * Launches a QuizServer
 *
 * Sets up the QuizController, QuizView, QuizFactory and QuizModel that are to be used
 * for the session.
 *
 * Used to take interactions from the User form either the SetupClient or the PlayerClient
 *
 * and push them to the QuizController to
 * carry out it's respective tasks.
 *
 *
 *
 *
 */
public interface QuizServer {

    /**
     * to create a quiz and then calls the method to store it in the QuizModel,
     * finally returning a brand new quiz id
     *
     * @return the new quiz id int
     */
    public int createQuizAndReturnId();

    /**
     * For adding a quiz to a QuizModel
     */
    public void addQuizToDataStore(QuizModel qm);
}
