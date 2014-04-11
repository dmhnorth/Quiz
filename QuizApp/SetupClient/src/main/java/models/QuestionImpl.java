package models;

import java.io.Serializable;

/**
 * Created by Dave on 12/03/2014.
 */
public class QuestionImpl implements Serializable, Question {

    private String question;
    private String[] answersChoices;
    private int correctAns;

    public QuestionImpl(String question, String[] answersChoices, int correctAns) {
        this.question = question;
        this.answersChoices = answersChoices;
        this.correctAns = correctAns;
    }

    @Override
    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void setAnswersChoices(String[] answersChoices) {
        this.answersChoices = answersChoices;
    }

    @Override
    public String[] getAnswersChoices() {
        return answersChoices;
    }

    @Override
    public void setCorrectAns(int correctAns) {
        this.correctAns = correctAns;
    }

    @Override
    public int getCorrectAns() {
        return correctAns;
    }
}
