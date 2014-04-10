package QuizServer.Assets;

import java.io.Serializable;

/**
 * Created by Dave on 12/03/2014.
 */
public class Question implements Serializable {



    private String question;
    private String[] answersChoices;
    private int correctAns;

    public Question(String question, String[] answersChoices, int correctAns) {
        this.question = question;
        this.answersChoices = answersChoices;
        this.correctAns = correctAns;
    }


    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswersChoices(String[] answersChoices) {
        this.answersChoices = answersChoices;
    }

    public String[] getAnswersChoices() {
        return answersChoices;
    }

    public void setCorrectAns(int correctAns) {
        this.correctAns = correctAns;
    }

    public int getCorrectAns() {
        return correctAns;
    }
}
