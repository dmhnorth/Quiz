package models;

import java.rmi.RemoteException;
import java.util.TreeMap;

/**
 * Persistent data store to contains the quizzes stored on the server
 *
 * Methods in this store should be synchronized in order to safely carry
 * them out
 */
public interface QuizServerModel {

    TreeMap<Integer, Quiz> getQuizzes();

    /**
     * generates a new id unique to this model
     */
    int generateId();

    /**
     * Adds a quiz to the data structure and returns it's id
     * @param quiz quiz just made
     * @return the id of the quiz
     */
    int addQuizToModel(Quiz quiz) throws RemoteException;

    /**
     * checks if the quiz results some one has just played beat that on the model
     * @param quizId is the id created
     * @param score the score they achieved
     * @param playerName the name they gave
     */
    void checkAndReplaceScore(int quizId, int score, String playerName) throws RemoteException;
}
