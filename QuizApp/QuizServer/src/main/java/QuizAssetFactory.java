import QuizServer.Assets.Question;
import QuizServer.Assets.Quiz;
import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Used to facilitate the legal creation of assets
 * from the assets taken in by QuizServerController and generate an id
 *
 * It verifies entries and uses the methods within the Quiz to package
 * a quiz
 *
 */
public interface QuizAssetFactory {

    /**
     * verifies that all the parameters are legal and then returns a quiz
     *
     * @param quizName
     * @param questions
     * @param answers
     * @param generatedId
     * @return a valid Quiz
     *
     *
     */
    public Quiz createQuiz(String quizName, Question[] questions, int[] answers, int generatedId) throws InvalidArgumentException;

//    /**
//     * verifies the size of the int
//     * verifies that all the parameters are legal and then returns a question
//     *
//     * @param answersChoices
//     * @param correctAns
//     *
//     * @return a valid Question
//     */
//    public Question createQuestion(String[] answersChoices, int[] correctAns) throws InvalidArgumentException;

}
