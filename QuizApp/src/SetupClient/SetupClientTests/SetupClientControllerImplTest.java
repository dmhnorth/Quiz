package SetupClient.SetupClientTests;

import QuizServer.QuizServerController;
import QuizServer.QuizServerControllerImpl;
import SetupClient.SetupClientController;
import SetupClient.SetupClientControllerImpl;
import SetupClient.SetupClientView;
import SetupClient.SetupClientViewImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SetupClientControllerImplTest {

    SetupClientController setupClientController;
    SetupClientView setupClientView;

    QuizServerController quizServerController;


    @Before
    public void setUp() throws Exception {
        quizServerController = new QuizServerControllerImpl();
        setupClientView = new SetupClientViewImpl();

        setupClientController = new SetupClientControllerImpl(quizServerController, setupClientView);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testChooseTask() throws Exception {

    }

    @Test
    public void testCreateAQuiz() throws Exception {
        setupClientController.createAQuiz();
    }

    @Test
    public void testNameOfAuthor() throws Exception {
        setupClientController.nameOfAuthor();
    }

    @Test
    public void testNameOfQuiz() throws Exception {
        setupClientController.nameOfQuiz();
    }

    @Test
    public void testCreateAQuestion() throws Exception {
        setupClientController.createAQuestion();
    }

    @Test
    public void testPrintActiveQuizzes() throws Exception {

    }
}
