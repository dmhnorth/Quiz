package QuizServer.Assets;

import java.io.Serializable;

public class Quiz implements Serializable{

    private String quizName;
    private int quizId;
    private Question[] questions;
    private int[] answers;
    private int highScore;
    private String highScoreHolder;
    private boolean quizLock;


    public Quiz(String quizName, Question[] questions, int[] answers, int generatedId){
        this.quizName = quizName;
        this.questions = questions;
        this.answers = answers;
        this.quizId = generatedId;

        this.highScore = 0;
        this.highScoreHolder = "No one yet!";
        this.quizLock = true;

    }

    public void setQuizName(String quizName){
    }

    public String getQuizName(){
        return quizName;
    }

    public void setQuizId(int id){
        this.quizId = id;
    }

    public int getQuizId(){
        return quizId;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getHighScore(){
        return highScore;
    }

    public void setHighScoreHolder(String highScoreHolder){
        this.highScoreHolder = highScoreHolder;
    }

    public String getHighScoreHolder(){
        return highScoreHolder;
    }

    public void setQuestions(Question[] questions){
        this.questions = questions;
    }

    public Question[] getQuestions(){
        return questions;
    }

    public boolean isQuizLocked() {
        return quizLock;
    }

    public void lockQuiz(){
        this.quizLock = true;
    }

    public  void unlockQuiz(){
        this.quizLock = false;
    }
}
