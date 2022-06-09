package sae.exception;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * The 31 mai 2022
 */
public class CommandNotFoundException extends Exception {

    private final String commandAsked;

    public CommandNotFoundException(String command) {
        this.commandAsked = command;
    }

    public String getMessage() {
        return "The command " + commandAsked + " cannot be found";
    }
}
