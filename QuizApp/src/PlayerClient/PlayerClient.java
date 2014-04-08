package PlayerClient;

/**
 * For users who connect to a QuizServer to enable them
 * to carry out the operations associated with
 * choosing and playing quizzes, along with
 * retrieving data about the Server's QuizModel
 *
 */
public interface PlayerClient { //needs to implement QuizServer methods

    /**
     * retrieves the quizzes on the server,
     * their ids and current Highscore and current HighScoreHolder
     */
    public void printListOfQuizzesOnServer();

    /**]
     * retrieves a quiz on the server and allows user to play
     * @param id the id number of the quiz user wants to play
     */
    public void playQuiz(int id);

}
