package utilities;

import models.QuizServerModel;

import java.io.*;

/**
 * This implementation of DataManager is dependent on the objects within the QuizServerModel
 * being serializable.
 *
 * @author Dave
 */
public class DataManagerImpl implements DataManager {

    final String FILENAME = "quizdata.txt";

    @Override
    public boolean dataFileExists() {
        return new File(FILENAME).exists();
    }

    @Override
    public QuizServerModel loadData() {
        QuizServerModel quizServerModel = null;
        ObjectInputStream decode;
        try {
            decode = new ObjectInputStream(new BufferedInputStream(new FileInputStream(FILENAME)));
            quizServerModel = (QuizServerModel) decode.readObject();
            decode.close();
        } catch (IOException | ClassNotFoundException e) {
            deleteCorruptData();
            loadData();
        }
        return quizServerModel;
    }

    @Override
    public void saveData(QuizServerModel quizServerModel) {
        ObjectOutputStream encode;
        try {
            encode = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FILENAME)));
            encode.writeObject(quizServerModel);
            encode.close();
        } catch (IOException ex2) {
            ex2.printStackTrace();
        }
    }

    @Override
    public void deleteCorruptData() {
        File file = new File(FILENAME);
        if(file.exists()) {
            file.delete();
            System.out.println("DATA CORRUPT - EXITING: Please start the Server again for fresh quiz data.");
            System.exit(0);
        }
    }
}
