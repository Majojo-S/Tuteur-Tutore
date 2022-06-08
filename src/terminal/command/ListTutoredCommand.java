package terminal.command;

import tutoring.tutored.Tutored;

public class ListTutoredCommand extends AbstractCommand implements ICommand {

    private static final String COMMAND_NAME = "list tutored";

    @Override
    public boolean execute() {
        System.out.println("----- Listing tutored -----");
        for (Tutored it : model.getTutored())
            System.out.println(it);
        return true;
    }
}
