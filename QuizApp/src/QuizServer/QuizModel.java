package QuizServer;

/**
 * Persistant data store to contains the quizzes stored on the server
 */
public interface QuizModel {

    /**
     * Generates a new id number for the quiz
     * @return id number generated from persistant data
     */
    public int generateId();
}
