package SetupClient;

public class SetupClientViewImpl implements SetupClientView {

    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Quiz Setup Client.\nWhat would you like to do?");
    }

    public void displayUserOptions() {
        System.out.println("Please Select an option by entering a number\n1. Create a Quiz\n2. View Quizzes on this Server\n3. Close and Exit");
    }

    public void inputError() {
        System.out.println("Sorry, I didn't understand that, please try again...");
    }
}
