package controllers;

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
        System.exit(0);

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

                    if (quizServerController.getModelQuizzes().isEmpty()) {
                        System.out.println("No quizzes on Server.");
                        chooseTask();
                        break;
                    }
                    view.whatQuizWouldYouLikeToPlay();
                    int id = 0;
                    try {
                        id = Integer.parseInt(sc.nextLine());

                    } catch (NumberFormatException n) {
                        System.out.print("Enter a number 1-4: ");
                        chooseTask();
                    }

                    try {
                        playQuiz(id);
                    } catch (NullPointerException n) {
                        System.out.println("Sorry, A quiz with that ID does not exist.");
                    }
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
                    System.out.println("'" + choice + "' is not an option.");
                    view.tryAgain();
                    chooseTask();
                    break;
            }
        } catch (Exception e) {
//            System.err.println(">>'case' option exception thrown...<<" + e);
//            e.printStackTrace();
            view.inputError();
            chooseTask();
        }
    }

    /*
    Used to play a quiz
     */
    private void playQuiz(int id) throws RemoteException {

        Quiz quiz = quizServerController.getQuizViaId(id);

        view.beginAQuiz(quiz);
        String playerName = getUserName();

        int score = 0;
        String userInput;


        for (int k = 0; k < quiz.getQuestions().length; k++) {
            int questionNo = 0;
            questionNo++;
            System.out.println("Question number: " + questionNo);
            String[][] currentQn = new String[][]{quiz.getQuestions()[k]};

            //TODO format this question properly and have it so that quizzes can be more than one question on the player
                view.printAQuestionAndChoices(currentQn[k]);

            userInput = sc.nextLine();

            if (currentQn[k][4].equals(userInput)) {
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

        if (userName == null || userName.trim().isEmpty()) {
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