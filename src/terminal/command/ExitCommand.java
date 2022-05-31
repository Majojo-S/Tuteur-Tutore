package terminal.command;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * The 31 mai 2022
 */
public class ExitCommand extends AbstractCommand implements ICommand {

    @Override
    public boolean execute() {
        System.exit(1);
        return true;
    }
}
