package terminal.command;

import tutoring.tutor.Tutor;
import tutoring.tutored.Tutored;

import java.util.Scanner;

public class CreateTutoredCommand extends AbstractCommand implements ICommand {

    @Override
    public boolean execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Prenom du tutoré");
        String firstName = sc.nextLine();
        System.out.println("Nom du tutoré");
        String lastName = sc.nextLine();

        Tutored tutored = new Tutored(firstName, lastName);
        model.addTutored(tutored);

        return false;
    }
}
