package QuizServer;

/**
 * Not entirely sure how this is going to fit into the pattern anymore.
 * Probably should be the main
 *
 * The core interface that is used Server AND Client side for communication via RMI
 * All processing goes on here or in one of the connected factories.
 *
 * Should be created using a QuizController and QuizModel on the Server end,
 * On the client end it will only be using the interface so only the methods will be used.
 *
 */
public interface QuizServer {

    /**
     * Calls the QuizController to initiate the building of a quiz for a user,
     * which then sends the questions and answers to the QuizFactory,
     * creates a quiz and then calls the method to store it in the QuizModel,
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
