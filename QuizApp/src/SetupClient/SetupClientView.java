package SetupClient;

/**
 * For displaying the terminal printouts the user requires to enter data.
 * Partly for cleaning up the contents of The SetupClientController.
 */
public interface SetupClientView {


    /**
     * displays a welcome message
     */
    public void displayWelcomeMessage();

    /**
     * Prints the options available to the user
     */
    void displayUserOptions();

    /**
     * if a user has typed an incorrect entry into the program
     */
    public void inputError();
}
