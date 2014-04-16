package models;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Dave on 12/03/2014.
 */

public class QuestionImpl extends UnicastRemoteObject implements Serializable, Question {
    private String question;
    private String[] answersChoices;
    private int correctAns;

    public QuestionImpl(String question, String[] answersChoices, int correctAns) throws RemoteException {
        this.question = question;
        this.answersChoices = answersChoices;
        this.correctAns = correctAns;
    }


    @Override
    public void setQuestion(String question) throws RemoteException {
        this.question = question;
    }

    @Override
    public String getQuestion() throws RemoteException {
        return question;
    }

    @Override
    public void setAnswersChoices(String[] answersChoices) throws RemoteException {
        this.answersChoices = answersChoices;
    }

    @Override
    public String[] getAnswersChoices() throws RemoteException {
        return answersChoices;
    }

    @Override
    public void setCorrectAns(int correctAns) throws RemoteException {
        this.correctAns = correctAns;
    }

    @Override
    public int getCorrectAns() throws RemoteException {
        return correctAns;
    }
}
