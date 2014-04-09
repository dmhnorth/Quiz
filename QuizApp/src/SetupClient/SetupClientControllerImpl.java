package SetupClient;

import QuizServer.QuizServerController;

import java.util.Scanner;

public class SetupClientControllerImpl implements SetupClientController {

    private final QuizServerController sController;
    private final SetupClientView view;

    public Scanner sc;

    public SetupClientControllerImpl(QuizServerController qServerController, SetupClientView setupClientView) {

        this.sController = qServerController;
        this.view = setupClientView;

        sc = new Scanner(System.in);

    }

    public void start() {

        view.displayWelcomeMessage();
        chooseTask();








        //TODO the main bulk of the program that the user interacts with

    }

    public void chooseTask() {
        view.displayUserOptions();
        try {
            int choice;
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
//                    System.out.println("Choice to create quiz:");
                    createAQuiz();
                    break;
                case 2:
                    System.out.println("Choice to print Quizzes:");
                    printActiveQuizzes();
                    break;
                default:
                    System.out.println("You haven't chosen anything\nTry again!\n");
                    chooseTask();
                }
        } catch (Exception e) {
            view.inputError();
            chooseTask();
        }
    }

    public void createAQuiz() {
        //TODO take the user through a quiz creation service
    }

    public void printActiveQuizzes() {
        //TODO prettyPrint the quizzes on the server
    }


}
