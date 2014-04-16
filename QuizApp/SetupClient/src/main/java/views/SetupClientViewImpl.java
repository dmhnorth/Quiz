package views;


import controllers.QuizServerController;
import models.Quiz;

import java.rmi.RemoteException;
import java.util.Map;

public class SetupClientViewImpl implements SetupClientView {

    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Quiz Setup Client.\nWhat would you like to do?");
    }

    public void displayUserOptions() {
        System.out.println("Please Select an option by entering a number\n1. Create a Quiz\n2. View Quizzes on this Server\n3. Close and Exit");
    }

    public void inputError() {
        System.out.println("Sorry, I didn't understand that, please try again...");
    }


    public void createAQuiz() {
        System.out.println("Let's create a quiz.\nWe will need to create a few things\nA Quiz name, some Questions, and you'll also need to let us know the correct answers!");

    }

    public void nameOfAuthor() {
        System.out.println("Firstly, what is your name?");
    }

    public void nameOfQuiz() {
        System.out.println("So what would you like to call your quiz?");
    }

    public void createAQuestion() {
        System.out.println("Lets create a question!\nWe need a Question, three optional answers, and a number indicating the correct answer!\nPlease type the question you would like to ask:");
    }

    public void createAnAnswer() {
        System.out.println("Enter an answer option:");

    }

    public void createACorrectAnswer() {
        System.out.println("Now enter the selection number of the correct answer");
    }

    public void isThisCorrect() {
        System.out.println("Is this alright?\n(1)Yes\n(2)No");
    }

    public void printQuestion(String[] qn) throws RemoteException {
        System.out.println("For the question: " + "'" + qn[0] + "'");
        System.out.println("You gave the options:\n" + qn[1] + "\n" + qn[2] + "\n" + qn[3] + "\n");
    }



    public void printQuestionAnswer(String correctAns) throws RemoteException {
        System.out.println("The correct answer is: " + correctAns);
    }


    public void tryAgain() {
        System.out.println("Okay...let's try that again...");
    }

    public void thatsDone() {
        System.out.println("Done. On to the next thing...");
    }

    public void createQuestions() {
        System.out.println("Let's create a set of questions and correct answers");
    }

    public void howManyQuestions() {
        System.out.println("How many questions would you like to create for this quiz?");
    }

    public void questionHasBeenSet() {
        System.out.println("Question has been set.");
    }

    public void questionsHaveBeenSet() {
        System.out.println("The Questions have been set.");
    }

    public void doYouWantToPublishThisQuiz() {
        System.out.println("Do you wish to upload this quiz?");
    }

    public void uploadingQuiz(Quiz quiz) throws RemoteException {
        System.out.println("You decided to upload the quiz: " + quiz.getQuizName());
    }

    public void editAQuiz(Quiz quiz) throws RemoteException {
        System.out.println("You are about to edit the quiz: " + quiz.getQuizName());
    }


    public void quizCreatedWithId(int quizId) throws RemoteException {
        System.out.println("You've created a quiz with the id: " + quizId);
    }

    @Override
    public void thanksForUsingTheQuizSetupClient() {
        System.out.println("Thanks for using the quiz setup client.");
    }

    public void printActiveQuizzes(QuizServerController quizServerController) throws RemoteException {
        System.out.println("\nThe active quizzes on the server are: ");

        Map<Integer,Quiz> quizzes;
        quizzes = quizServerController.getModelQuizzes();

        for(Quiz quiz: quizzes.values()){
            System.out.println("Quiz ID: " + quiz.getQuizId() + ": " +  quiz.getQuizName());
        }
    }

    public void printQuizDetails(String quizAuthor, String quizName, String[][] questions, int quizId) throws RemoteException {
        System.out.println("The quiz details for " + "'" + quizName + "'");
        System.out.println("\nQuiz ID: " + quizId);
        System.out.println("Quiz Author: " + quizAuthor);
        System.out.println("\nQuiz Questions: ");
        printQuestionsAndAnswers(questions);
    }

//TODO finish writing up this utter shit
    private void printQuestionsAndAnswers(String[][] questions) throws RemoteException {
        for(int x = 0;x < questions[x].length;x++) {
            printQuestion(quiz.getQuestions()[x]);
            printQuestionAnswer(quiz.getQuestions()[x][4]);
            System.out.println("\n");
        }
    }
}
