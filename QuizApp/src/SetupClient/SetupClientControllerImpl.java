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
                    System.out.println("Choice to create quiz:");
                    createAQuiz();
                    break;
                case 2:
                    System.out.println("Choice to print Quizzes:");
                    printActiveQuizzes();
                    break;
                default:
                    view.tryAgain();
                    chooseTask();
                    break;
                }
        } catch (Exception e) {
            System.out.println("We've exited the menu/finished the program.");
//            view.inputError();
//            chooseTask();
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
        questions = createAQuestionSet();

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
        view.thatsDone();
        return quizAuthor;
    }

    public String nameOfQuiz() {

        view.nameOfQuiz();

        String quizName = null;
        try {
            quizName = sc.nextLine();
        } catch (Exception e) {
            view.inputError();
            nameOfQuiz();
        }
        view.thatsDone();
        return quizName;
    }

    public Question createAQuestion(){

        Question result = null;
        Question tempQn = null;




        String[] answersChoices = new String[3];
        int correctAns = 0;


        view.createAQuestion();
        String question = sc.nextLine();

        System.out.println("you entered: " + question);
        view.thatsDone();



        for(int x = 0; x < answersChoices.length; x++) {

            view.createAnAnswer();
            answersChoices[x] = sc.nextLine();
        }
        view.thatsDone();


        view.createACorrectAnswer();
        correctAns = Integer.parseInt(sc.nextLine());

        tempQn = new Question(question, answersChoices, correctAns);

//check if User happy with the question
        view.printQuestion(tempQn);
        view.printQuestionAnswer(tempQn);

        view.isThisQuestionCorrect();
        switch (Integer.parseInt(sc.nextLine())){
            case 1:
                result = new Question(question, answersChoices, correctAns);
                System.out.println("Question has been set");
                return result;

            case 2:
                view.tryAgain();
                result = createAQuestion();
                System.out.println("No? alright let's do it again...");
                return result;

            default:
                System.out.println("Alright, I'll assume that was correct.");
                result = new Question(question, answersChoices, correctAns);
                return result;
        }

    }

    public Question[] createAQuestionSet() {
        Question[] result;

        view.createQuestions();
        view.howManyQuestions();

        result = new Question[Integer.parseInt(sc.nextLine())];

        for(int x = 0;x < result.length; x++){
            result[x] = createAQuestion();
        }

        view.questionsHaveBeenSet();
        return result;
    }

    public void printActiveQuizzes() {
        //TODO prettyPrint the quizzes on the server
    }


}
