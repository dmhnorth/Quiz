package controllers;


import models.Question;
import models.QuestionImpl;
import models.Quiz;
import models.QuizImpl;
import views.SetupClientView;

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
        //TODO make sure the program disconnects from the server


    }

    public void chooseTask() {
        view.displayUserOptions();
        try {
            int choice;
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    Quiz quiz = createAQuiz();
//                   TODO quizServerController.addQuizAndReturnId(quiz);
                    System.out.println("You've created and uploaded the quiz with the id: " + quiz.getQuizId() + "\nWhat Now?");
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
                    view.tryAgain();
                    chooseTask();
                    break;
            }
        } catch (Exception e) {
            view.tryAgain();
            view.inputError();
            chooseTask();
        }
    }


    //TODO separate all the methods in here into separate ones and add the retry section to them!
    public Quiz createAQuiz() {
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
        answers = generateAnswerArray(questions);
        quizId = 1; //TODO implement this instead quizServerController.generateIdUniqueOnThisModel();

        quiz = new QuizImpl(quizAuthor, quizName, questions, answers, quizId);

        view.printQuizDetails(quiz);
        view.doYouWantToPublishThisQuiz();
        view.isThisCorrect();


        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                view.uploadingQuiz(quiz);
                view.quizCreatedWithId(quiz);
                return quiz;
            default:
                view.editAQuiz(quiz);
                editAQuiz(quiz);
                view.quizCreatedWithId(quiz);
                return quiz;
        }
    }

    private Quiz editAQuiz(Quiz quiz) {
        //TODO Add editing methods
        Quiz result = new QuizImpl(quiz.getQuizAuthor(), quiz.getQuizName(), quiz.getQuestions(), quiz.getAnswers(), quiz.getQuizId());
        view.printQuizDetails(quiz);
        System.out.println("Sorry, edit quiz is not yet available.");
        return result;
    }

    private int[] generateAnswerArray(Question[] questions) {

        int[] result = new int[questions.length];
        for (int x = 0; x < questions.length; x++) {
            result[x] = questions[x].getCorrectAns();
        }
//        System.out.println("Question array generated.");
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

    public Question createAQuestion() {

        Question result;


//create the question asked
        String question = question();
        view.thatsDone();

//create the answer options
        String[] answersChoices = answersChoices();


        view.thatsDone();

//Choose a correct answer
        int correctAns = correctAns();

        result = new QuestionImpl(question, answersChoices, correctAns);


//check if User happy with the question
        view.printQuestion(result);
        view.printQuestionAnswer(result);

        view.isThisCorrect();
        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                result = new QuestionImpl(question, answersChoices, correctAns);
                view.questionHasBeenSet();
                return result;

            case 2:
                view.tryAgain();
                result = createAQuestion();
                return result;

            default:
                view.questionHasBeenSet();
                result = new QuestionImpl(question, answersChoices, correctAns);
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

        if (question.equals(null) || question.equals("")) {
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


    public Question[] createAQuestionSet() {
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
