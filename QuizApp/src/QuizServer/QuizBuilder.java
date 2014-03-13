package QuizServer;


import QuizServer.Assets.Question;

/**
 * This class is used to create the on screen terminal interaction
 * that a user requires to create a quiz.
 *
 * It then uses a QuizFactory to ensure the creation of a quiz is done correctly.
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
     * The user inputs a question and answer that
     * is added to the question and answer set via the createAQuestion method
     */
    public void createQuestionAndAnswer();

    /**
     * Used by create QuestionAndAnswer() to package a question and add it to the QuestionSet
     */
    public Question packageQuestion(String[] ansChoices, int[] correctAnswer);

    /**
     *
     * @return the set of questions created
     */
    public Question[] returnQuestionSet();

    /**
     *
     * @return the Array of correct answers the user generated
     */
    public int[] returnCorrectAnswers();
}
