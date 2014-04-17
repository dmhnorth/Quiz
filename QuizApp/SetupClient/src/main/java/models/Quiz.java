package models;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Quiz extends Remote {

    String getQuizAuthor() throws RemoteException;

    String getQuizName() throws RemoteException;

    int getQuizId() throws RemoteException;

    void setHighScore(int highScore) throws RemoteException;

    int getHighScore() throws RemoteException;

    void setHighScoreHolder(String highScoreHolder) throws RemoteException;

    String getHighScoreHolder() throws RemoteException;

    String[][] getQuestions() throws RemoteException;

    boolean isQuizLocked() throws RemoteException;

    void lockQuiz() throws RemoteException;

    void unlockQuiz() throws RemoteException;

    String quizDetailsToString() throws RemoteException;
}
