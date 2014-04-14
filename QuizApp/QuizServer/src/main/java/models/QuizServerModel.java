package models;

import java.util.TreeMap;

/**
 * Persistent data store to contains the quizzes stored on the server
 *
 * Methods in this store should be synchronized in order to safely carry
 * them out
 */
public interface QuizServerModel {

    /**
     * checks if there is a Quiz Model present on this server, if so, loads and returns it
     * if not, it sends back a new one
     *
     * @return existing QuizServerModel OR a new one if no model exists
     *
     */
    QuizServerModel tryLoadQuizServerModel();

    TreeMap<Integer, Quiz> getQuizzes();

    /**
     * generates a new id unique to this model
     */
    int generateId();

    /**
     * Adds a quiz to the data structure and returns it's id
     * @param quiz
     * @return
     */
    int addQuizToModel(Quiz quiz);

    /**
     * checks if the quiz results some one has just played beat that on the model
     * @param quizId
     * @param score
     * @param playerName
     */
    void checkAndReplaceScore(int quizId, int score, String playerName);
}
