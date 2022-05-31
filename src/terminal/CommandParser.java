package terminal;

import terminal.command.exception.CommandNotFoundException;
import terminal.command.ExitCommand;
import terminal.command.HelpCommand;
import terminal.command.ICommand;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * The 31 mai 2022
 */
public class CommandParser {

    private static final String DELIMITER_CHAR = " ";

    /**
     * Parse and find the associated command
     *
     * @param command String
     * @return ICommand
     */
    public ICommand parse(String command) throws CommandNotFoundException {
        String[] keyWords = separateKeywords(command);
        ICommand c        = null;
        switch (keyWords[0]) {
            case "help":
                c = new HelpCommand();
                break;
            case "exit":
                c = new ExitCommand();
                break;
        }

        if (c == null) throw new CommandNotFoundException(command);
        return c;
    }

    /**
     * Separate all words from input
     *
     * @return String
     */
    private String[] separateKeywords(String command) {
        return command.split(DELIMITER_CHAR);
    }
}
