package models;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.TreeMap;

public class QuizServerModelImpl implements QuizServerModel, Serializable {


    private static int counter = 0;

    //TODO this is reiinitialising everytime i start the program
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

        System.out.println("before trying to add " + quiz.getQuizId());
        quizzes.put(quiz.getQuizId(), quiz);
        System.out.println("after adding " + quiz.getQuizId());
        testPrintContainer();
        return quiz.getQuizId();
    }

    @Override
    public void checkAndReplaceScore(int quizId, int score, String playerName) throws RemoteException {
        Quiz quiz = quizzes.get(quizId);

        if(quiz.getHighScore() < score) {
            quiz.setHighScore(score);
            quiz.setHighScoreHolder(playerName);
        } else {
            //Do Nothing
        }
    }

    @Override
    public void testPrintContainer() throws RemoteException {

        if(quizzes.isEmpty()) {
            System.out.printf("The QuizServerModel is empty on this server");
        }

        for (Quiz q: quizzes.values()) {
            System.out.println(q.quizDetailsToString());
        }
    }

}

