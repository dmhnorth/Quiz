package controllers;

import models.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.TreeMap;

public class QuizServerControllerImpl extends UnicastRemoteObject implements QuizServerController {

    QuizServerModel quizServerModel;

    public QuizServerControllerImpl(QuizServerModel quizServerModel) throws RemoteException {
        this.quizServerModel = quizServerModel;
    }


    @Override
    public int addQuizAndReturnId(Quiz quiz) throws RemoteException {
        quizServerModel.addQuizToModel(quiz);
            return quiz.getQuizId();
    }

    @Override
    public int generateIdUniqueOnThisModel() throws RemoteException {
        return quizServerModel.generateId();
    }

    @Override
    public TreeMap<Integer, Quiz> getModelQuizzes() throws RemoteException {
        return quizServerModel.getQuizzes();
    }

    @Override
    public void submitScore(int quizId, int score, String playerName) throws RemoteException {
        quizServerModel.checkAndReplaceScore(quizId, score, playerName);
    }

    @Override
    public Quiz getQuizViaId(int id) throws RemoteException {
        return quizServerModel.getQuizzes().get(id);
    }

    @Override
    public Question buildQuestion(String[] question) throws RemoteException {
        return new QuestionImpl(question);
    }

    @Override
    public Quiz buildQuiz(String quizAuthor, String quizName, String[][] questions, int quizId) throws RemoteException {
        return new QuizImpl(quizAuthor, quizName, questions, quizId);
    }

    public QuizServerModel getQuizServerModel() {
        return quizServerModel;
    }

    public void setQuizServerModel(QuizServerModel quizServerModel) {
        this.quizServerModel = quizServerModel;
    }
}
