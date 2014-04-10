package QuizServer.Assets;

import java.io.Serializable;

public class Quiz implements Serializable{

    private String quizAuthor;
    private String quizName;
    private int quizId;
    private Question[] questions;
    private int[] answers;
    private int highScore;
    private String highScoreHolder;
    private boolean quizLock;


    public Quiz(String quizAuthor, String quizName, Question[] questions, int[] answers, int generatedId){
        this.quizAuthor = quizAuthor;
        this.quizName = quizName;
        this.questions = questions;
        this.answers = answers;
        this.quizId = generatedId;

        setHighScore(0);
        setHighScoreHolder("No one yet!");
        unlockQuiz();

    }

    public String getQuizName(){
        return quizName;
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
