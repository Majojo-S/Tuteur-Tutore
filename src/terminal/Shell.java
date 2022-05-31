package terminal;

import terminal.command.exception.CommandNotFoundException;
import terminal.command.ICommand;

import java.util.Scanner;

/**
 * Represent the shell in the application context
 *
 * @author quentin.barlet.etu
 * The 31 mai 2022
 */
public class Shell {

    private static final String SHELL_ENTRY = "[SAE_201-202]> ";

    /**
     * Launch the shell
     */
    public static void launch() throws InterruptedException {
        Scanner       scanner = new Scanner(System.in);
        CommandParser cp      = new CommandParser();
        while (true) {
            System.out.print(SHELL_ENTRY);
            String userInput = scanner.nextLine();
            try {
                ICommand command = cp.parse(userInput);
                command.execute();
            } catch (CommandNotFoundException e) {
                System.err.println(e.getMessage());
                // FIXME 31/05/2022 quentin.barlet.etu: The catch is displayed after the SHELL_ENTRY
                Thread.sleep(100);
            }
        }
    }
}
