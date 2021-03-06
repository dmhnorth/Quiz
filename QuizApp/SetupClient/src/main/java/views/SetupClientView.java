package views;


import controllers.QuizServerController;

import java.rmi.RemoteException;

/**
 * For displaying the terminal printouts the user requires to enter data.
 * Partly for cleaning up the contents of The controllers.SetupClientController.
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
     * Asks user if something is correct and gives them a yes or no option
     */
    void isThisCorrect();

    /**
     * Prints out a question and it's answer
     *
     * @param qn
     */
    void printQuestion(String[] qn) throws RemoteException;

    /**
     * Prints out the correct answer integer
     */
    void printQuestionAnswer(String correctAns) throws RemoteException;

    /**
     * print a summary of the details within a give quiz
     *
     * @param quizAuthor the author of the currently being made quiz
     * @param quizName   the name of the currently being made quiz
     * @param questions  the questions currently being built
     * @param quizId     the id currently set
     * @throws RemoteException
     */
    void printQuizDetails(String quizAuthor, String quizName, String[][] questions, int quizId) throws RemoteException;

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

    /**
     * Notifying a question has been set
     */
    void questionHasBeenSet();

    /**
     * ask User if they want to publish the quiz they have made
     */
    void doYouWantToPublishThisQuiz();

    /**
     * Notification user decided to upload the quiz to the server
     */
    void uploadingQuiz() throws RemoteException;

    /**
     * Tells a user they are about to edit a quiz
     *
     * @param quiz quiz to be edited
     */
    void editAQuiz(int quiz) throws RemoteException;

    /**
     * Tell a user they have created a quiz and give them the id on the terminal
     *
     * @param quiz quiz just created
     */
    void quizCreatedWithId(int quiz) throws RemoteException;

    /**
     * Exit message on client
     */
    void thanksForUsingTheQuizSetupClient();

    /**
     * Fetches and prints on terminal the quizzes on the server we are currently connected to
     *
     * @param quizServerController the server object required
     */
    void printActiveQuizzes(QuizServerController quizServerController) throws RemoteException;
}
