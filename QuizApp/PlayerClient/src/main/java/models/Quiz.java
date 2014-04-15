package models;

import java.rmi.Remote;

public interface Quiz extends Remote {
    String getQuizAuthor();

    String getQuizName();

    int getQuizId();

    void setHighScore(int highScore);

    int getHighScore();

    void setHighScoreHolder(String highScoreHolder);

    String getHighScoreHolder();

    Question[] getQuestions();

    boolean isQuizLocked();

    void lockQuiz();

    void unlockQuiz();

    String quizDetailsToString();
}
