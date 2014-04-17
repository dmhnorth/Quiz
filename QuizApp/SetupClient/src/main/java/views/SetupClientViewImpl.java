package views;


import controllers.QuizServerController;
import models.Quiz;

import java.rmi.RemoteException;
import java.util.Map;

public class SetupClientViewImpl implements SetupClientView {

    @Override
    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Quiz Setup Client.\nWhat would you like to do?");
    }

    @Override
    public void displayUserOptions() {
        System.out.println("Please Select an option by entering a number\n1. Create a Quiz\n2. View Quizzes on this Server\n3. Close and Exit");
    }

    @Override
    public void inputError() {
        System.out.println("Sorry, I didn't understand that, please try again...");
    }


    @Override
    public void createAQuiz() {
        System.out.println("Let's create a quiz.\nWe will need to create a few things\nA Quiz name, some Questions, and you'll also need to let us know the correct answers!");

    }

    @Override
    public void nameOfAuthor() {
        System.out.println("Firstly, what is your name?");
    }

    @Override
    public void nameOfQuiz() {
        System.out.println("So what would you like to call your quiz?");
    }

    @Override
    public void createAQuestion() {
        System.out.println("\nWe need a Question, three optional answers, and a number indicating the correct answer!\nPlease type the question you would like to ask:");
    }

    @Override
    public void createAnAnswer() {
        System.out.println("Enter an answer option:");

    }

    @Override
    public void createACorrectAnswer() {
        System.out.println("Now enter the selection number of the correct answer");
    }

    @Override
    public void isThisCorrect() {
        System.out.println("Is this alright?\n(1)Yes\n(2)No");
    }

    @Override
    public void printQuestion(String[] qn) throws RemoteException {
        System.out.println("For the question: " + "'" + qn[0] + "'");
        System.out.println("You gave the options:\n1)" + qn[1] + "\n2)" + qn[2] + "\n3)" + qn[3]);
    }


    @Override
    public void printQuestionAnswer(String correctAns) throws RemoteException {
        System.out.println("The correct answer is: " + correctAns + "\n");
    }

    @Override
    public void tryAgain() {
        System.out.println("Okay...let's try that again...\n");
    }

    @Override
    public void thatsDone() {
        System.out.println("Done. On to the next thing...");
    }

    @Override
    public void createQuestions() {
        System.out.println("Let's create a set of questions and correct answers");
    }

    @Override
    public void howManyQuestions() {
        System.out.println("How many questions would you like to create for this quiz?");
    }

    @Override
    public void questionHasBeenSet() {
        System.out.println("Question has been set.");
    }

    @Override
    public void questionsHaveBeenSet() {
        System.out.println("The Questions have been set.");
    }

    @Override
    public void doYouWantToPublishThisQuiz() {
        System.out.println("Do you wish to upload this quiz?");
    }

    @Override
    public void uploadingQuiz() throws RemoteException {
        System.out.println("You decided to upload the quiz...");
    }

    @Override
    public void editAQuiz(int id) throws RemoteException {
        System.out.println("You are about to edit the quiz: " + id);
    }

    @Override
    public void quizCreatedWithId(int quizId) throws RemoteException {
        System.out.println("You've created a quiz with the id: " + quizId);
    }

    @Override
    public void thanksForUsingTheQuizSetupClient() {
        System.out.println("Thanks for using the quiz setup client.");
    }

    @Override
    public void printActiveQuizzes(QuizServerController quizServerController) throws RemoteException {
        System.out.println("\nThe active quizzes on the server are: ");
        Map<Integer, Quiz> quizzes;
        quizzes = quizServerController.getModelQuizzes();
        for (Quiz quiz : quizzes.values()) {
            System.out.println(quiz.quizDetailsToString());
        }
    }

    @Override
    public void printQuizDetails(String quizAuthor, String quizName, String[][] questions, int quizId) throws RemoteException {
        System.out.println("\nThe quiz details for " + "'" + quizName + "'");
        System.out.println("Quiz ID: " + quizId);
        System.out.println("Quiz Author: " + quizAuthor);
        System.out.println("\nQuiz Questions: ");
        printQuestionsAndAnswers(questions);
    }

    private void printQuestionsAndAnswers(String[][] questions) throws RemoteException {

        for (String[] question : questions) {
            printQuestion(new String[]{question[0], question[1], question[2], question[3]});
            printQuestionAnswer(question[4]);
            System.out.println("\n");
        }
    }
}
