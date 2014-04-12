package models;

public interface Quiz {
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

    int[] getAnswers();

    String quizDetailsToString();
}
