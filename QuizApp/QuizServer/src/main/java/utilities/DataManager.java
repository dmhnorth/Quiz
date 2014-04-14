package utilities;


import models.QuizServerModel;

/**
 *
 * An interface to create DataManagers that save and load a file for the
 * QuizServerModel class
 * @author Dave
 *
 */
public interface DataManager {

    /**
     * determines whether a data file exists for the QuizServerModel save data
     *
     * @return boolean in respect to whether the data file already exists
     */
    public abstract boolean dataFileExists();

    /**
     * loads a given QuizServerModel
     *
     * @return Object[]
     */
    public abstract QuizServerModel loadData();

    /**
     * takes the QuizServerModel and saves it out to a file.
     *
     * @param quizServerModel
     *
     */
    public abstract void saveData(QuizServerModel quizServerModel);

}