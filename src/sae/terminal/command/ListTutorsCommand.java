package sae.terminal.command;

import sae.tutoring.tutor.Tutor;

public class ListTutorsCommand extends AbstractCommand implements ICommand {

    private static final String COMMAND_NAME = "List all tutors";

    @Override
    public boolean execute() {
        System.out.println("----- Listing tutors -----");
        for (Tutor it : model.getTutors())
            System.out.println(it);

        return true;
    }
}
