package controllers;

import models.Quiz;
import views.PlayerClientView;

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




    public void playQuiz(int id) {

        Quiz quiz = retrieveQuiz(id);
        String playerName = getUserName();
        int score = 0;

        //This is the current work in progress.

        submitScore(quiz.getQuizId(), score, playerName);

    }

    private Quiz retrieveQuiz(int id) {
        return quizServerController.getQuizViaId(id);
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


    public void submitScore(int quizId, int score, String playerName) {
        System.out.println("Submitting score to server.");
        quizServerController.submitScore(quizId, score, playerName);
        System.out.println("Score has been submitted.");
    }
}
