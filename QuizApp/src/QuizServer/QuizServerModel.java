package QuizServer;

/**
 * Persistent data store to contains the quizzes stored on the server
 *
 * Methods in this store should be synchronized in order to safely carry
 * them out
 */
public interface QuizServerModel {

    /**
     * Generates a new id number for the quiz
     * @return id number generated from persistent data
     */
    public int generateId();





}
