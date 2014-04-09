package QuizServer;


import QuizServer.Assets.Question;

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
     */
    public int createQuizAndReturnId();



    /**
     * The user declares their quiz's name
     */
    public void setQuizName();

    /**
     * The user inputs a question and answer that
     * is added to the question and answer set via the createAQuestion method
     */
    public void createQuestionAndAnswer();

    /**
     * Used by createQuestionAndAnswer() to package a question
     * and add it to the QuestionSet
     * @return Question
     */
    public Question packQuestion(String[] ansChoices, int[] correctAnswer);

// Model interactions

    /**
     * For adding a quiz to a QuizServerModel
     */
    public void addQuizToDataStore(QuizServerModel qm);


    /**
     *
     * @return the Array of correct answers the user generated
     */
    public int[] returnCorrectAnswers();
}
