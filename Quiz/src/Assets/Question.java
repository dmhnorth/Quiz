package Assets;

/**
 * Created by Dave on 12/03/2014.
 */
public class Question {

    private String[] answersChoices;
    private int[] correctAns;

    public Question(String[] answersChoices, int[] correctAns) {
        this.answersChoices = answersChoices;
        this.correctAns = correctAns;
    }

}
