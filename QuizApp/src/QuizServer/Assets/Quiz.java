package QuizServer.Assets;

import java.io.Serializable;

public class Quiz implements Serializable{

    private String quizName;
    private int quizId;
    private Question[] questions;
    private int highScore;
    private String highScoreHolder;
    private boolean quizLock;

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
