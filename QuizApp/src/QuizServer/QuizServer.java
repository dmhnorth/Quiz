package QuizServer;

import QuizServer.Assets.Question;
import QuizServer.Assets.Quiz;

/**
 * The core interface that is used Server AND Client side for communication via RMI
 * All processing goes on here or in one of the connected factories.
 *
 * Should be created using a QuizFactory and QuizContainer on the Server end,
 * On the client end it will only be using the interface so only the methods will be used.
 *
 */
public interface QuizServer {


    /**
     * Calls the QuizBuilder to initiate the building of a quiz
     */
    public userMakeAQuiz();


    /**
     * Sends the questions and answers to the QuizFactory,
     * creates a quiz and then calls the method to store it in the QuizContainer,
     * finally returning a brand new quiz id
     *
     * @param questions
     * @param answers
     * @return the new quiz id int
     */
    public int createQuizAndReturnId(String[] questions, int[] answers);

    /**
     * Used to actually create a quiz in the given factory
     */
    public Quiz createQuiz();

    /**
     * Used to create a question
     */
    public Question createQuestion(String[] ansChoices, int[] correctAnswer);

    /**
     * For adding a quiz to the QuizContainer
     */
    public void addQuizToDataStore(QuizContainer qc);
}