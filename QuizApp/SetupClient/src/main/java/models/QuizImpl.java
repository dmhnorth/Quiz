package models;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class QuizImpl extends UnicastRemoteObject implements Serializable, Quiz {

    private String quizAuthor;
    private String quizName;
    private int quizId;
    private Question[] questions;
    private int highScore;
    private String highScoreHolder;
    private boolean quizLock;

    public QuizImpl(String quizAuthor, String quizName, Question[] questions, int generatedId) throws RemoteException {
        this.quizAuthor = quizAuthor;
        this.quizName = quizName;
        this.questions = questions;
        this.quizId = generatedId;

        setHighScore(0);
        setHighScoreHolder("No one yet!");
        unlockQuiz();

    }

    @Override
    public String getQuizAuthor() throws RemoteException {
        return quizAuthor;
    }

    @Override
    public String getQuizName() throws RemoteException{
        return quizName;
    }

    @Override
    public int getQuizId() throws RemoteException{
        return quizId;
    }

    @Override
    public void setHighScore(int highScore) throws RemoteException {
        this.highScore = highScore;
    }

    @Override
    public int getHighScore() throws RemoteException{
        return highScore;
    }

    @Override
    public void setHighScoreHolder(String highScoreHolder) throws RemoteException{
        this.highScoreHolder = highScoreHolder;
    }

    @Override
    public String getHighScoreHolder() throws RemoteException{
        return highScoreHolder;
    }

    @Override
    public Question[] getQuestions() throws RemoteException{
        return questions;
    }

    @Override
    public boolean isQuizLocked() throws RemoteException {
        return quizLock;
    }

    @Override
    public void lockQuiz() throws RemoteException{
        this.quizLock = true;
    }

    @Override
    public  void unlockQuiz() throws RemoteException{
        this.quizLock = false;
    }

    @Override
    public String quizDetailsToString() throws RemoteException {
        return "Quiz ID: " + getQuizId() + "\nQuiz Name: " + getQuizName() + "\nHigh Score holder: " + getHighScoreHolder() + "\nScore: " + getHighScore();
    }
}
