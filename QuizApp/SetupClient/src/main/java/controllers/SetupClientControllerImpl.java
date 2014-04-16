package controllers;


import models.Question;
import models.Quiz;
import views.SetupClientView;

import java.rmi.RemoteException;
import java.util.Scanner;

public class SetupClientControllerImpl implements SetupClientController {

    private final QuizServerController quizServerController;
    private final SetupClientView view;

    public Scanner sc;

    public SetupClientControllerImpl(QuizServerController quizServerController, SetupClientView setupClientView) {
        this.quizServerController = quizServerController;
        this.view = setupClientView;
        sc = new Scanner(System.in);
    }

    public void start() {

        view.displayWelcomeMessage();
        chooseTask();
        view.thanksForUsingTheQuizSetupClient();
        System.exit(0);
    }

    public void chooseTask() {
        view.displayUserOptions();
        try {
            int choice;
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    Quiz quiz = createAQuiz();
                    view.quizCreatedWithId(quiz);
                    //TODO this is where the error is
                    System.out.println("You've created and uploaded the quiz with the id: " + quizServerController.addQuizAndReturnId(quiz) + "\nWhat Now?");
                    chooseTask();
                    break;
                case 2:
                    view.printActiveQuizzes(quizServerController);
                    chooseTask();
                    break;
                case 3:
                    //Do nothing and exit
                    break;
                default:
                    System.err.println(choice + " is not an option.");
                    view.tryAgain();
                    chooseTask();
                    break;
            }
        } catch (Exception e) {
            System.err.println(">>'case' option exception thrown...<<" + e);
            e.printStackTrace();
            view.tryAgain();
            chooseTask();
        }
    }


    //TODO separate all the methods in here into separate ones and add the retry section to them!
    public Quiz createAQuiz() throws RemoteException {
        Quiz quiz;
        String quizAuthor;
        String quizName;
        Question[] questions;
        int quizId;


        view.createAQuiz();
        quizAuthor = nameOfAuthor();
        quizName = nameOfQuiz();
        questions = createAQuestionSet();
        quizId = quizServerController.generateIdUniqueOnThisModel();

        quiz = quizServerController.buildQuiz(quizAuthor, quizName, questions, quizId);

        view.printQuizDetails(quiz);
        view.doYouWantToPublishThisQuiz();
        view.isThisCorrect();


        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                view.uploadingQuiz(quiz);
                return quiz;
            default:
                view.editAQuiz(quiz);
                editAQuiz(quiz);
                view.quizCreatedWithId(quiz);
                return quiz;
        }
    }

    private Quiz editAQuiz(Quiz quiz) throws RemoteException {
        //TODO Add editing methods
        Quiz result = quizServerController.buildQuiz(quiz.getQuizAuthor(), quiz.getQuizName(), quiz.getQuestions(), quiz.getQuizId());

        view.printQuizDetails(quiz);
        System.out.println("Sorry, edit quiz is not yet available.");
        return result;
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

    public Question createAQuestion() throws RemoteException {

        Question result;


//create the question asked
        String question = question();
        view.thatsDone();

//create the answer options
        String[] answersChoices = answersChoices();
        view.thatsDone();

//Choose a correct answer
        int correctAns = correctAns();
        result = quizServerController.buildQuestion(question, answersChoices, correctAns);

//check if User happy with the question
        view.printQuestion(result);
        view.printQuestionAnswer(result);

        view.isThisCorrect();
        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                result = quizServerController.buildQuestion(question, answersChoices, correctAns);
                view.questionHasBeenSet();
                return result;

            case 2:
                view.tryAgain();
                result = createAQuestion();
                return result;

            default:
                view.questionHasBeenSet();
                result = quizServerController.buildQuestion(question, answersChoices, correctAns);
                return result;
        }

    }


    // Methods for creating a question
    private String[] answersChoices() {
        String[] answersChoices = new String[3];
        for (int x = 0; x < answersChoices.length; x++) {
            System.out.print((x + 1) + ") ");
            view.createAnAnswer();
            answersChoices[x] = sc.nextLine();
        }
        return answersChoices;
    }

    private String question() {

        view.createAQuestion();
        String question = sc.nextLine();

        if (question.equals("")) {
            return question();
        } else {
            System.out.println("you entered: " + question);
            return question;
        }
    }

    private int correctAns() {

        int result;

        view.createACorrectAnswer();
        try {
            result = Integer.parseInt(sc.nextLine());
            if (!(result > 0 && result < 4)) {
                return correctAns();
            }
        } catch (Exception e) {
            return correctAns();
        }
        return result;
    }


    public Question[] createAQuestionSet() throws RemoteException {
        Question[] result;

        view.createQuestions();
        view.howManyQuestions();

        result = new Question[Integer.parseInt(sc.nextLine())];

        for (int x = 0; x < result.length; x++) {
            result[x] = createAQuestion();
        }

        view.questionsHaveBeenSet();
        return result;
    }



}
