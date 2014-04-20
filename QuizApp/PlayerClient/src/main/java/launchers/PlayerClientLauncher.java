package launchers;

/**
 * This is used connecting a PlayerClientController
 * to a Quiz Server via RMI
 */
public interface PlayerClientLauncher {

    /**
     * begins and connects a PlayerClientLauncher whilst connecting it to a view and the server
     */
    public void launch();
}