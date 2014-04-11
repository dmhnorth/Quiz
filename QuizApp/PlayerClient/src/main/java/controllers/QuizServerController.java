package controllers;

import models.Quiz;
import models.QuizServerModel;

import java.util.TreeMap;


/**
 *
 * It manipulates the QuizServerModel by taking inputs from a user.
 *
 * It uses a QuizAssetFactory to ensure the creation of a quiz and questions is done correctly.
 *
 * It also builds the Quiz Assets required to create a
 * Quiz on the server side (a QuestionSet, an AnswerSet)

 *
 * It should be constructed with a QuizServerModel, QuizAssetFactory.
 *
 *
 *
 *
 */
public interface QuizServerController {

    /**
     *
     * Variables to consider this must create one way or another = String quizName, Question[] questions, int[] answers, int generatedId
     *
     * to create a quiz and then calls the method to store it in the QuizServerModel,
     * finally returning the new quiz id
     *
     * @return the new quiz id int
     * @param quiz
     */
    public int addQuizAndReturnId(Quiz quiz);


// Model interactions

    /**
     * For adding a quiz to a QuizServerModel
     */
    public void addQuizToDataStore(QuizServerModel qm);

    /**
     * Get a new Id generated by the model
     */
    public int generateIdUniqueOnThisModel();

    /**
     * Print the quizzes on this Server and their lock status
     */
    void printActiveQuizzes();

    /**
     * Retrieves the quizzes currently available on the server as List
     * @return
     */
    TreeMap<Integer, Quiz> getModelQuizzes();
}
