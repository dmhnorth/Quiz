import QuizServer.Assets.Question;
import QuizServer.Assets.Quiz;

/**
 * For users who connect to a QuizServerLauncher to enable them
 * to carry out the operations associated with
 * choosing and playing quizzes, along with
 * retrieving data about the QuizServerModel
 *
 * Constructed with a model (Server side) and with a view (on the Client side)
 *
 */
public interface PlayerClientController { //needs to implement QuizServerController methods


    /**
     * Launches the user interface of the PlayerClientController
     */
    public void start();

    /**
     * retrieves the quizzes on the server,
     * prints their ids and current Highscore and current HighScoreHolder
     */
    public void printListOfQuizzesOnServer();

    /**
     * retrieves a quiz on the server with the given id and allows user to play
     * @param id the id number of the quiz user wants to play
     */
    public void playQuiz(int id);

    /**
     * For submitting a high score back to the server with a given
     * quiz id, score, and high score holder
     */
    public void submitScore(int quizId, int score, String playerName);



}
