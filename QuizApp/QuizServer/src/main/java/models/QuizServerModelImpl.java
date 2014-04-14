package models;

import java.io.Serializable;
import java.util.TreeMap;

public class QuizServerModelImpl implements QuizServerModel, Serializable {


    private static int counter = 0;

    private TreeMap<Integer, Quiz> quizzes;

    public QuizServerModelImpl() {

    }


    @Override
    public QuizServerModel tryLoadQuizServerModel() {
        QuizServerModel result;




        //TODO create the loading or creating new of a Quizservermodel here, currently just returns a new one.

//        else {
//            result = new QuizServerModelImpl();
//        }
        return this;
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
    public int addQuizToModel(Quiz quiz) {
        quizzes.put(quiz.getQuizId(), quiz);
        return quiz.getQuizId();
    }

    @Override
    public void checkAndReplaceScore(int quizId, int score, String playerName) {
        Quiz quiz = quizzes.get(quizId);

        if(quiz.getHighScore() < score) {
            quiz.setHighScore(score);
            quiz.setHighScoreHolder(playerName);
        } else {
            //Do Nothing
        }
    }

}

