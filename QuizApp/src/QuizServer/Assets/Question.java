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

    public String getQuestion() {
        return question;
    }

    public String[] getAnswersChoices() {
        return answersChoices;
    }

    public int getCorrectAns() {
        return correctAns;
    }
}
