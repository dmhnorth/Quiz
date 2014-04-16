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
    private String correctAns;

    public QuestionImpl(String[] question) throws RemoteException {
        this.question = question[0];
        this.answersChoices = question;
        this.correctAns = question[4];
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
    public void setCorrectAns(String correctAns) throws RemoteException {
        this.correctAns = correctAns;
    }

    @Override
    public String getCorrectAns() throws RemoteException {
        return correctAns;
    }
}
