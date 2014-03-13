package QuizServer;


import QuizServer.Assets.Question;

/**
 * This class is used to create the on screen terminal interaction
 * that a user requires to create a quiz.
 *
 * It also builds the Quiz Assets required to create a
 * Quiz on the server side (a QuestionSet, an AnswerSet)
 */
public interface QuizBuilder {

    /**
     * The user declares their name
     */
    public void declareUserName();

    /**
     * The user declares their quiz's name
     */
    public void createQuizName();

    /**
     * The user creates a question and answer that
     * is added to the question and answer set
     */
    public void createAQuestion();

    /**
     *
     * @return the set of questions created
     */
    public Question[] returnQuestionSet();

    /**
     *
     * @return the int array of correct questions
     */
    public int[] returnCorrectAnswers();
}
