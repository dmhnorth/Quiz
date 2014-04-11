package launchers;

/**
 * This is used connecting a controllers.PlayerClientController
 * to a Quiz Server via RMI
 */
public interface PlayerClientLauncher {

    /**
     * creates a launcher.launchers.PlayerClientLauncher and launches it
     */
    public void launch();
}