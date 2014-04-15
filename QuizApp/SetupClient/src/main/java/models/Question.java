package models;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Question extends Remote {

    void setQuestion(String question) throws RemoteException;

    String getQuestion()throws RemoteException;

    void setAnswersChoices(String[] answersChoices) throws RemoteException;

    String[] getAnswersChoices() throws RemoteException;

    void setCorrectAns(int correctAns) throws RemoteException ;

    int getCorrectAns() throws RemoteException ;
}
