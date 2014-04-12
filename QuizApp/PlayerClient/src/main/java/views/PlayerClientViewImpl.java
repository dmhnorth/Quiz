package views;

import controllers.QuizServerController;
import models.Question;
import models.Quiz;

import java.util.Map;

public class PlayerClientViewImpl implements PlayerClientView {

    @Override
    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Quiz Player Client.\nWhat would you like to do?");
    }

    @Override
    public void thanksForUsingTheQuizSetupClient() {
        System.out.println("Thanks for using the quiz player client. I hope you had fun.");
    }

    @Override
    public void displayUserOptions() {
        System.out.println("Please Select an option by entering a number\n1. View Quizzes available on this server\n2. Play a Quiz\n3. Check out high scores and holders for each quiz\n4. Close and Exit");
    }

    @Override
    public void tryAgain() {
        System.out.println("Okay...let's try that again...");
    }

    @Override
    public void printActiveQuizzes(QuizServerController quizServerController) {
        System.out.println("\nThe active quizzes on the server are: ");

        Map<Integer,Quiz> quizzes;
        quizzes = quizServerController.getModelQuizzes();

        for(Quiz quiz : quizzes.values()) {
            System.out.println(quiz.quizDetailsToString());
        }
    }

    @Override
    public void whatQuizWouldYouLikeToPlay() {
        System.out.println("Please enter the ID number of the quiz you would like to play: ");
    }

    @Override
    public void inputError() {
        System.out.println("Sorry, I didn't understand that, please try again...");
    }


    @Override
    public void checkOutRankings(QuizServerController quizServerController) {

        Map<Integer,Quiz> quizzes;
        quizzes = quizServerController.getModelQuizzes();

        System.out.println("Here are the High Scores on the quizzes on this Server: ");

        for(Quiz quiz: quizzes.values()) {
            System.out.println(quiz.toString());
        }
    }

    @Override
    public void enterAUserName() {
        System.out.println("Please enter a User Name: ");
    }

    @Override
    public void beginAQuiz(Quiz quiz) {
        System.out.println("You're about to play the quiz " + quiz.quizDetailsToString());
    }

    @Override
    public void printAQuestionAndChoices(Question qn) {
        System.out.println(qn.getQuestion());

        for(int x = 0;x < qn.getAnswersChoices().length;x++) {
            System.out.println((x + 1) + "." + qn.getAnswersChoices()[x]);
        }
    }


}
