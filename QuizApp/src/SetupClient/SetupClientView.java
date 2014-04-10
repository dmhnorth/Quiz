package SetupClient;

import QuizServer.Assets.Question;
import QuizServer.Assets.Quiz;

/**
 * For displaying the terminal printouts the user requires to enter data.
 * Partly for cleaning up the contents of The SetupClientController.
 */
public interface SetupClientView {


    /**
     * displays a welcome message
     */
    public void displayWelcomeMessage();

    /**
     * Prints the options available to the user
     */
    void displayUserOptions();

    /**
     * if a user has typed an incorrect entry into the program
     */
    public void inputError();

    /**
     * introduction to creating a Quiz
     */
    void createAQuiz();

    /**
     * Request a name of the Author
     */
    void nameOfAuthor();

    /**
     * Requests a name for the quiz
     */
    void nameOfQuiz();

    /**
     * Introduces the creating of a question
     */
    void createAQuestion();

    /**
     * Requests the creation of an answer option
     */
    void createAnAnswer();

    /**
     * Requests which number is the correct answer
     */
    void createACorrectAnswer();

    /**
     * Asks user if the question is correct
     */
    void isThisQuestionCorrect();

    /**
     * Prints out a question and it's answer
     */
    void printQuestion(Question qn);

    /**
     * Prints out the correct answer integer
     */
    void printQuestionAnswer(Question qn);




    /**
     * print a summary of the details within a give quiz
     * @param quiz
     */
    void printQuizDetails(Quiz quiz);

    /**
     * tells a User to try again
     */
    void tryAgain();

    /**
     * Clarifies when something has been processed
     */
    void thatsDone();

    /**
     * Asks the user to create some questions
     */
    void createQuestions();

    /**
     * Asks for the number of questions a user would like for this quiz
     */
    void howManyQuestions();

    /**
     * states that all the questions have been set
     */
    void questionsHaveBeenSet();
}
