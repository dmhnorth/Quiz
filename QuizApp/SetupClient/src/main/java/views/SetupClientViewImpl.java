package views;


import controllers.QuizServerController;
import models.Question;
import models.Quiz;

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

    public void printQuestion(Question qn) {
        System.out.println("For the question: " + "'" + qn.getQuestion() + "'");

        System.out.println("You gave the options:");
        for(int x = 0;x < qn.getAnswersChoices().length;x++) {
            System.out.println((x + 1) + "." + qn.getAnswersChoices()[x]);
            }
    }

    public void printQuestionAnswer(Question qn) {
        System.out.println("The correct answer is: " + qn.getCorrectAns());
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

    public void uploadingQuiz(Quiz quiz) {
        System.out.println("You decided to upload the quiz: " + quiz.getQuizName());
    }

    public void editAQuiz(Quiz quiz) {
        System.out.println("You are about to edit the quiz: " + quiz.getQuizName());
    }


    public void quizCreatedWithId(Quiz quiz) {
        System.out.println("You've created a quiz with the id: " + quiz.getQuizId());
    }

    @Override
    public void thanksForUsingTheQuizSetupClient() {
        System.out.println("Thanks for using the quiz setup client.");
    }

    //TODO this will have to be recreated using a treemap structure
    public void printActiveQuizzes(QuizServerController quizServerController) {
        System.out.println("\nThe active quizzes on the server are: ");

        for(Quiz quiz : quizServerController.getModelQuizzes()){
            System.out.println("Quiz ID: " + quiz.getQuizId() + ": " +  quiz.getQuizName());
        }
    }

    public void printQuizDetails(Quiz quiz) {
        System.out.println("The quiz details for " + "'" + quiz.getQuizName()+ "'");
        System.out.println("\nQuiz ID: " + quiz.getQuizId());
        System.out.println("Quiz Author: " + quiz.getQuizAuthor());
        System.out.println("\nQuiz Questions: ");
        printQuestionsAndAnswers(quiz);
    }


    private void printQuestionsAndAnswers(Quiz quiz) {
        for(int x = 0;x < quiz.getQuestions().length;x++) {
            printQuestion((quiz.getQuestions()[x]));
            printQuestionAnswer((quiz.getQuestions()[x]));
            System.out.printf("\n");
        }
    }
}
