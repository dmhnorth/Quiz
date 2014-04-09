package QuizServer;

/**
 *
 * Launches a Server
 *
 * Sets up the QuizController, QuizAssetFactory and loads QuizServerModel that are to be used
 * for the session.
 *
 * Used to take interactions from the User form either the SetupClientController or the PlayerClientController
 *
 * and push them to the QuizController to
 * carry out it's respective tasks.
 *
 *
 *
 *
 */
public interface QuizServerLauncher {

    /**
     * to create a quiz and then calls the method to store it in the QuizServerModel,
     * finally returning a brand new quiz id
     *
     * @return the new quiz id int
     */
    public int createQuizAndReturnId();

    /**
     * For adding a quiz to a QuizServerModel
     */
    public void addQuizToDataStore(QuizServerModel qm);
}
