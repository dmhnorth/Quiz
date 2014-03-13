package Assets;

import java.io.Serializable;

public class Quiz implements Serializable{

    private String quizName;
    private int quizId;
    private Question[] questions;
    private int highScore;
    private String highScoreHolder;
    private boolean quizLock;




    public Quiz(Question[] questions, String quizName){
        //set a quizId here
        //load the current highScore from persistent data-store
        //load the current highScoreHolder from persistent data-store

        this.quizName = quizName;
        this.questions = questions;
    }

    public String getQuizName(){
        return quizName;
    }

    public int getQuizId(){
        return quizId;
    }

    public int getHighScore(){
        return highScore;
    }

    public String getHighScoreHolder(){
        return highScoreHolder;
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
