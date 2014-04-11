package controllers;

import models.Question;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import views.SetupClientView;

import java.util.Scanner;

import static org.mockito.Mockito.mock;

public class SetupClientControllerImplTest {

    SetupClientController setupClientController;
    SetupClientView setupClientView;

    QuizServerController quizServerController;

    Scanner sc = new Scanner(System.in);

    Question testQn;

    @Before
    public void setUp() throws Exception {

        quizServerController = mock(QuizServerController.class);
        setupClientView = mock(SetupClientView.class);
        testQn = mock(Question.class);

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
    public void testCreateAQuestionSet() throws Exception {
        setupClientController.createAQuestionSet();
    }

    @Test
    public void testPrintActiveQuizzes() throws Exception {

    }
}
