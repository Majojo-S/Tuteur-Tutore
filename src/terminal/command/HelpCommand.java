package terminal.command;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * The 31 mai 2022
 */
public class HelpCommand extends AbstractCommand implements ICommand {

    private static final String COMMAND_NAME = "help";

    private static final String[][] commands = {{"Help", "Show this help"}, {"list tutors", "Display all tutors"}, {"list tutored", "Display all tutored"}
    };

    @Override
    public boolean execute() {
        for (String[] item : commands)
            System.out.println(item[0] + " => " + item[1]);
        return true;
    }

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

}
