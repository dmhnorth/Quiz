package models;

/**
 * Persistent data store to contains the quizzes stored on the server
 *
 * Methods in this store should be synchronized in order to safely carry
 * them out
 */
public interface QuizServerModel {






    /**
     * nested class used for generating ids unique to this QuizServerModel
     *
     * requires a static initial variable to exist
     */
    public interface idGenerator{

        /**
         * Generates a new id number unique each time
         * @return id number generated from persistent data
         */
        public int generateNewId();

    };




}
