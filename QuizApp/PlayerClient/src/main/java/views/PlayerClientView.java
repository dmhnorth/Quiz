package views;


import controllers.QuizServerController;

public interface PlayerClientView {


    void displayWelcomeMessage();

    void thanksForUsingTheQuizSetupClient();

    void displayUserOptions();

    void tryAgain();

    void printActiveQuizzes(QuizServerController quizServerController);

    void whatQuizWouldYouLikeToPlay();

    void inputError();

    void checkOutRankings(QuizServerController quizServerController);

    void enterAUserName();
}
