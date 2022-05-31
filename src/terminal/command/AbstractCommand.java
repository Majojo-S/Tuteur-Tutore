package terminal.command;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * The 31 mai 2022
 */
abstract public class AbstractCommand {

    protected static String COMMAND_NAME = "";

    protected String getMessage() {
        return COMMAND_NAME;
    }

    protected String getCommandName() {
        return COMMAND_NAME;
    }

}
