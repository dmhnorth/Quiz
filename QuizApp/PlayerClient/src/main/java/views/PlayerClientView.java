package views;


import controllers.QuizServerController;
import models.Question;
import models.Quiz;

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

    void beginAQuiz(Quiz quiz);

    void printAQuestionAndChoices(Question q);
}
