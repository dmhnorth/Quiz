package controllers;

import models.Quiz;
import models.QuizServerModel;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.TreeMap;

public class QuizServerControllerImpl extends UnicastRemoteObject implements QuizServerController {

    QuizServerModel quizServerModel;

    public QuizServerControllerImpl(QuizServerModel quizServerModel) throws RemoteException {
        this.quizServerModel = quizServerModel;
    }


    @Override
    public int addQuizAndReturnId(Quiz quiz) {
        quizServerModel.addQuizToModel(quiz);
        return quiz.getQuizId();
    }

    @Override
    public int generateIdUniqueOnThisModel() {
        return quizServerModel.generateId();
    }

    @Override
    public TreeMap<Integer, Quiz> getModelQuizzes() {
        return quizServerModel.getQuizzes();
    }

    @Override
    public void submitScore(int quizId, int score, String playerName) {
        quizServerModel.checkAndReplaceScore(quizId, score, playerName);
    }

    @Override
    public Quiz getQuizViaId(int id) {
        return quizServerModel.getQuizzes().get(id);
    }

    public QuizServerModel getQuizServerModel() {
        return quizServerModel;
    }

    public void setQuizServerModel(QuizServerModel quizServerModel) {
        this.quizServerModel = quizServerModel;
    }
}
