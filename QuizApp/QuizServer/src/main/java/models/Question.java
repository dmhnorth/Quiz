package models;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Question extends Remote {

    void setQuestion(String question);

    String getQuestion()throws RemoteException;

    void setAnswersChoices(String[] answersChoices);

    String[] getAnswersChoices();

    void setCorrectAns(int correctAns);

    int getCorrectAns();
}
