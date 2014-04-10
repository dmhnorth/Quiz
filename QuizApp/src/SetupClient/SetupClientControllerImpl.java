package SetupClient;

import QuizServer.Assets.Question;
import QuizServer.Assets.Quiz;
import QuizServer.QuizServerController;

import java.util.Scanner;

public class SetupClientControllerImpl implements SetupClientController {

    private final QuizServerController sController;
    private final SetupClientView view;

    public Scanner sc;

    public SetupClientControllerImpl(QuizServerController qServerController, SetupClientView setupClientView) {

        this.sController = qServerController;
        this.view = setupClientView;

        sc = new Scanner(System.in);

    }

    public void start() {

        view.displayWelcomeMessage();
        chooseTask();








        //TODO the main bulk of the program that the user interacts with

    }

    public void chooseTask() {
        view.displayUserOptions();
        try {
            int choice;
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
//                    System.out.println("Choice to create quiz:");
                    createAQuiz();
                    break;
                case 2:
                    System.out.println("Choice to print Quizzes:");
                    printActiveQuizzes();
                    break;
                default:
                    System.out.println("You haven't chosen anything\nTry again!\n");
                    chooseTask();
                }
        } catch (Exception e) {
            view.inputError();
            chooseTask();
        }
    }


    //TODO separate all the methods in here into separate ones and add the retry section to them!
    public void createAQuiz() {
        Quiz quiz = null;
        String quizAuthor;
        String quizName;
        Question[] questions;
        int answers[];
        int quizId;

        view.createAQuiz();


        quizAuthor = nameOfAuthor();


        quizName = nameOfQuiz();

        view.createAQuestion();


        view.printQuizDetails(quiz);




    }

    //createAQuiz user input methods

    public String nameOfAuthor() {

        view.nameOfAuthor();

        String quizAuthor = null;
        try {
            quizAuthor = sc.nextLine();
        } catch (Exception e) {
            view.inputError();
            nameOfAuthor();
        }
        return quizAuthor;
    }

    public String nameOfQuiz() {

        view.nameOfQuiz();

        String quizName = null;
        try {
            quizName = sc.nextLine();
        } catch (Exception e) {
            view.inputError();
            nameOfAuthor();
        }
        return quizName;
    }

    public Question createAQuestion(){

        Question result = null;
        Question tempQn = null;
        String question = null;

        String[] answersChoices = new String[3];
        int correctAns = 0;


        view.createAQuestion();



        view.createAnAnswer();


        view.createACorrectAnswer();

        view.isThisQuestionCorrect();
        view.printQuestion(tempQn);
        view.printQuestionAnswer(tempQn);

        int choice = sc.nextInt();

        switch (choice){
            case 1:
                result.setQuestion(tempQn.getQuestion());
                result.setAnswersChoices(tempQn.getAnswersChoices());
                result.setCorrectAns(tempQn.getCorrectAns());

            case 2:
                System.out.println("Okay, lets try again...\n");
                result = createAQuestion();
        }
        return result;
    }

    public void printActiveQuizzes() {
        //TODO prettyPrint the quizzes on the server
    }


}
