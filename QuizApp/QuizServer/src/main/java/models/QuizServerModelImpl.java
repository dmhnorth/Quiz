package models;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.TreeMap;

public class QuizServerModelImpl implements QuizServerModel, Serializable {

    private static int counter = 0;
    private TreeMap<Integer, Quiz> quizzes = new TreeMap<>();

    public QuizServerModelImpl() {
    }

    @Override
    public TreeMap<Integer, Quiz> getQuizzes() {
        return quizzes;
    }

    @Override
    public int generateId() {
        return counter++;
    }

    @Override
    public int addQuizToModel(Quiz quiz) throws RemoteException {
        quizzes.put(quiz.getQuizId(), quiz);
        System.out.println("Quiz just added to server = " + quiz.getQuizId() + " | " + quiz.getQuizName());
        return quiz.getQuizId();
    }

    @Override
    public void checkAndReplaceScore(int quizId, int score, String playerName) throws RemoteException {
        Quiz quiz = quizzes.get(quizId);
        if (quiz.getHighScore() <= score) {
            quiz.setHighScore(score);
            quiz.setHighScoreHolder(playerName);
        }
    }

    @Override
    public void printContainer() throws RemoteException {

        System.out.println("Quizzes on this server:\n");

        if (quizzes.isEmpty()) {
            System.out.println("The QuizServerModel is empty on this server.");
        }

        for (Quiz q : quizzes.values()) {
            System.out.println(q.quizDetailsToString() + "\n");
        }
        System.out.println("--- Quiz Server is ready ---");
    }
}

