package QuizServer.Assets;

import java.io.Serializable;

/**
 * Created by Dave on 12/03/2014.
 */
public class Question implements Serializable {

    private String[] answersChoices;
    private int[] correctAns;

    public Question(String[] answersChoices, int[] correctAns) {
        this.answersChoices = answersChoices;
        this.correctAns = correctAns;
    }

}
