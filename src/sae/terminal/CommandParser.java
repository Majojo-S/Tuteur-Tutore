package sae.terminal;

import sae.exception.CommandNotFoundException;
import sae.terminal.command.CreateTutorCommand;
import sae.terminal.command.CreateTutoredCommand;
import sae.terminal.command.ExitCommand;
import sae.terminal.command.GraphCommand;
import sae.terminal.command.HelpCommand;
import sae.terminal.command.ICommand;
import sae.terminal.command.ListTutoredCommand;
import sae.terminal.command.ListTutorsCommand;

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
        ICommand c = null;
        switch (keyWords[0]) {
            case "help":
                c = new HelpCommand();
                break;
            case "exit":
                c = new ExitCommand();
                break;
            case "list":
                if (keyWords[1].equals("tutors")) c = new ListTutorsCommand();
                if (keyWords[1].equals("tutored")) c = new ListTutoredCommand();
                break;
            case "tutor":
                if (keyWords[1].equals("add")) c = new CreateTutorCommand();
                break;
            case "tutored":
                if (keyWords[1].equals("add")) c = new CreateTutoredCommand();
                break;
            case "graph":
                c = new GraphCommand();
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
