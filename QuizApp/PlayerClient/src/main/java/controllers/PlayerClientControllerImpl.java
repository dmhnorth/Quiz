package controllers;

import models.Question;
import models.Quiz;
import views.PlayerClientView;

import java.rmi.RemoteException;
import java.util.Scanner;

public class PlayerClientControllerImpl implements PlayerClientController {

    private final QuizServerController quizServerController;
    private final PlayerClientView view;

    public Scanner sc;

    public PlayerClientControllerImpl(QuizServerController quizServerController, PlayerClientView playerClientView) {
        this.quizServerController = quizServerController;
        this.view = playerClientView;
        sc = new Scanner(System.in);
    }

    @Override
    public void start() {

        view.displayWelcomeMessage();
        chooseTask();
        view.thanksForUsingTheQuizSetupClient();

    }

    private void chooseTask() {
        view.displayUserOptions();
        try {
            int choice;
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    view.printActiveQuizzes(quizServerController);
                    chooseTask();
                    break;
                case 2:
                    view.whatQuizWouldYouLikeToPlay();
                    int id = Integer.parseInt(sc.nextLine());
                    playQuiz(id);
                    chooseTask();
                    break;
                case 3:
                    view.checkOutRankings(quizServerController);
                    chooseTask();
                    break;
                case 4:
                    //Do nothing and exit
                    break;
                default:
                    System.err.println(choice + " is not an option.");
                    view.tryAgain();
                    chooseTask();
                    break;
            }
        } catch (Exception e) {
            System.err.println(">>'case' option exception thrown...<<" + e + " The Stacktrace: ");
            e.printStackTrace();
            view.inputError();
            chooseTask();

        }
    }

    /*
    Used to play a quiz
     */
    private void playQuiz(int id) throws RemoteException {

        Quiz quiz = quizServerController.getQuizViaId(id);

        String playerName = getUserName();
        int score = 0;
        int userInput;
        view.beginAQuiz(quiz);



        for(Question qn : quiz.getQuestions()) {
            int questionNo = 0;
            questionNo++;
            System.out.println("Question number: " + questionNo);
            view.printAQuestionAndChoices(qn);

            int answer = qn.getCorrectAns();
            userInput = Integer.parseInt(sc.nextLine());


            if(answer == userInput) {
                score++;
            }

            view.userScore(quiz, score, playerName);
            submitScore(quiz.getQuizId(), score, playerName);
            view.doYouHaveTheNewHighScore(quizServerController.getQuizViaId(id), score, playerName);
        }
    }

    private String getUserName() {

        String userName;

        view.enterAUserName();
        userName = sc.nextLine();

        if(userName.equals("") || userName.equals(null)){
            getUserName();
        }
        return userName;
    }

    /*
     * For submitting a high score back to the server with a given
     * quiz id, score, and high score holder
     */
    private void submitScore(int quizId, int score, String playerName) throws RemoteException {
        System.out.println("Submitting score to server.");
        quizServerController.submitScore(quizId, score, playerName);
        System.out.println("Score has been submitted.");
    }
}