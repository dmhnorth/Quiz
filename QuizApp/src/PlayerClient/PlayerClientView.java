package PlayerClient;

import QuizServer.Assets.Question;

public interface PlayerClientView {

    /**
     *
     * prints a set of question in order
     */
    public Question[] returnQuestionSet();


}
