package views;


import controllers.QuizServerController;
import models.Question;
import models.Quiz;

import java.rmi.RemoteException;

public interface PlayerClientView {


    void displayWelcomeMessage();

    void thanksForUsingTheQuizSetupClient();

    void displayUserOptions();

    void tryAgain();

    void printActiveQuizzes(QuizServerController quizServerController) throws RemoteException;

    void whatQuizWouldYouLikeToPlay();

    void inputError();

    void checkOutRankings(QuizServerController quizServerController) throws RemoteException;

    void enterAUserName();

    void beginAQuiz(Quiz quiz);

    void printAQuestionAndChoices(Question q);

    void userScore(Quiz quiz, int score, String playerName);

    void doYouHaveTheNewHighScore(Quiz quiz, int score, String playerName);
}
