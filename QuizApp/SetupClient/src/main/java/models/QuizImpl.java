package models;

import java.io.Serializable;

public class QuizImpl implements Serializable, Quiz{

    private String quizAuthor;
    private String quizName;
    private int quizId;
    private Question[] questions;
    private int[] answers;
    private int highScore;
    private String highScoreHolder;
    private boolean quizLock;

    public QuizImpl(String quizAuthor, String quizName, Question[] questions, int[] answers, int generatedId){
        this.quizAuthor = quizAuthor;
        this.quizName = quizName;
        this.questions = questions;
        this.answers = answers;
        this.quizId = generatedId;

        setHighScore(0);
        setHighScoreHolder("No one yet!");
        unlockQuiz();

    }

    @Override
    public String getQuizAuthor() {
        return quizAuthor;
    }

    @Override
    public String getQuizName(){
        return quizName;
    }

    @Override
    public int getQuizId(){
        return quizId;
    }

    @Override
    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    @Override
    public int getHighScore(){
        return highScore;
    }

    @Override
    public void setHighScoreHolder(String highScoreHolder){
        this.highScoreHolder = highScoreHolder;
    }

    @Override
    public String getHighScoreHolder(){
        return highScoreHolder;
    }

    @Override
    public Question[] getQuestions(){
        return questions;
    }

    @Override
    public boolean isQuizLocked() {
        return quizLock;
    }

    @Override
    public void lockQuiz(){
        this.quizLock = true;
    }

    @Override
    public  void unlockQuiz(){
        this.quizLock = false;
    }

    @Override
    public int[] getAnswers() {
        return answers;
    }

    @Override
    public String quizDetailsToString() {
        return "Quiz ID: " + getQuizId() + "\nQuiz Name: " + getQuizName() + "\nHigh Score holder: " + getHighScoreHolder() + "\nScore: " + getHighScore();
    }
}
