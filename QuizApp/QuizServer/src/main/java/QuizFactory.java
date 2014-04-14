import com.sun.javaws.exceptions.InvalidArgumentException;
import models.Question;
import models.Quiz;

/**
 * Used to facilitate the legal creation of assets
 * from the assets taken in by QuizServerController and generate an id
 *
 * It verifies entries and uses the methods within the Quiz to package
 * a quiz
 *
 */
public interface QuizFactory {

    /**
     * verifies that all the parameters are legal and then returns a quiz
     *
     * @param quizName
     * @param questions
     * @param generatedId
     * @return a valid Quiz
     *
     *
     */
    public Quiz createQuiz(String quizName, Question[] questions, int generatedId) throws InvalidArgumentException;