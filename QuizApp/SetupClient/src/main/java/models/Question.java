package models;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The class that contains a question, answer and potential multiple choice answers
 */
public interface Question extends Remote {

    /**
     * For setting the original question that is to be asked of a user
     */
    void setQuestion(String question) throws RemoteException;

    /**
     * returns the question that is to be asked of a user
     * @return the question asked
     * @throws java.rmi.RemoteException
     */
    String getQuestion() throws RemoteException;

    /**
     * For setting the choices of answers a user may decide to ask from
     * @param answersChoices a variety of answers
     * @throws java.rmi.RemoteException
     */
    void setAnswersChoices(String[] answersChoices) throws RemoteException;

    /**
     * Returns the choices of answers for a user
     * @return potential answer options
     * @throws java.rmi.RemoteException
     */
    String[] getAnswersChoices() throws RemoteException;

    /**
     * to set the correct answer from the selection of answers
     * @param correctAns
     * @throws java.rmi.RemoteException
     */
    void setCorrectAns(String correctAns) throws RemoteException;

    /**
     * the correct answer option that has been set
     * @return the correct answer
     * @throws java.rmi.RemoteException
     */
    String getCorrectAns() throws RemoteException;
}
