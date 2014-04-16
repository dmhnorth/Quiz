package controllers;


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
                    int newQuizId = createAQuiz();
                    System.out.println("You've created and uploaded the quiz with the id: " + quizServerController.getQuizViaId(newQuizId).getQuizId() + "\nWhat Now?");
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
    public int createAQuiz() throws RemoteException {
        Quiz quiz;
        String quizAuthor;
        String quizName;
        String[][] questions;
        int quizId;


        view.createAQuiz();
        quizAuthor = nameOfAuthor();
        quizName = nameOfQuiz();
        questions = createAQuestionSet();
        quizId = quizServerController.generateIdUniqueOnThisModel();

        view.printQuizDetails(quizAuthor, quizName, questions, quizId);
        view.doYouWantToPublishThisQuiz();
        view.isThisCorrect();


        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                //TODO null
                view.uploadingQuiz();

                quizServerController.buildQuizOnServer(quizAuthor, quizName, questions, quizId);
                view.quizCreatedWithId(quizId);
                return quizId;
            default:
                view.editAQuiz(quizId);
                editAQuiz(quizAuthor, quizName, questions, quizId);
                //TODO possible error on quizid on next line
                view.quizCreatedWithId(quizId);
                return quizId;
        }
    }

    private void editAQuiz(String quizAuthor, String quizName, String[][] questions, int quizId) throws RemoteException {
        //TODO Add editing methods
        view.printQuizDetails(quizAuthor, quizName, questions, quizId);
        System.out.println("Sorry, edit quiz is not yet available.");
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

    public String[] createAQuestion() throws RemoteException {

        String[] result;

        String question = question();
        view.thatsDone();

        String[] answersChoices = answersChoices();
        view.thatsDone();

        String correctAns = correctAns();
        result = new String[]{question, answersChoices[0], answersChoices[1], answersChoices[2], correctAns};

//check if User happy with the question
        view.printQuestion(result);
        view.printQuestionAnswer(result[4]);

        view.isThisCorrect();
        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                quizServerController.buildQuestion(result);
                view.questionHasBeenSet();
                return result;

            case 2:
                view.tryAgain();
                result = createAQuestion();
                return result;

            default:
                view.questionHasBeenSet();
                quizServerController.buildQuestion(result);
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

    private String correctAns() {

        String result;

        view.createACorrectAnswer();
        try {
            result = sc.nextLine();
            if (result.equals("1") || result.equals("2") || result.equals("3")) {
                return result;
            } else {
                return correctAns();
            }
        } catch (Exception e) {
            return correctAns();
        }
    }


    public String[][] createAQuestionSet() throws RemoteException {
        String[][] result;

        view.createQuestions();
        view.howManyQuestions();

        int noOfQuestions = Integer.parseInt(sc.nextLine());
        result = new String[noOfQuestions][5];

        for (int x = 0; x < noOfQuestions; x++) {
            String[] tempQn = createAQuestion();
            System.arraycopy(tempQn, 0, result[x], 0, tempQn.length);
        }
        view.questionsHaveBeenSet();

        return result;
    }
}
