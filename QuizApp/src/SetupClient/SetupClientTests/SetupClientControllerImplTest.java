package SetupClient.SetupClientTests;

import QuizServer.Assets.Question;
import QuizServer.QuizServerController;
import QuizServer.QuizServerControllerImpl;
import SetupClient.SetupClientController;
import SetupClient.SetupClientControllerImpl;
import SetupClient.SetupClientView;
import SetupClient.SetupClientViewImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class SetupClientControllerImplTest {

    SetupClientController setupClientController;
    SetupClientView setupClientView;

    QuizServerController quizServerController;

    Scanner sc;


    @Before
    public void setUp() throws Exception {
        quizServerController = new QuizServerControllerImpl();
        setupClientView = new SetupClientViewImpl();
        setupClientController = new SetupClientControllerImpl(quizServerController, setupClientView);
        sc  = new Scanner(System.in);


        String question = "what is the correct answer?";
        String[] answerChoices = {"This is wrong.", "This is also wrong", "This is the right answer"};
        int correctAnswer = 2;
        Question testQn = new Question(question, answerChoices, correctAnswer);

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
    public void testCreateAQuestionSet() throws Exception {
        setupClientController.createAQuestionSet();
    }

    @Test
    public void testPrintActiveQuizzes() throws Exception {

    }
}
