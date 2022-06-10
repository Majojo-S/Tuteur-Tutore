package sae.terminal.command;

import java.util.Scanner;

import sae.tutor.Tutor;

public class CreateTutorCommand extends AbstractCommand implements ICommand {

    @Override
    public boolean execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Prenom du tuteur");
        String firstName = sc.nextLine();
        System.out.println("Nom du tuteur");
        String lastName = sc.nextLine();

        System.out.println("Niveau d'étude");
        short grade = sc.nextShort();

        Tutor tutor = new Tutor(firstName, lastName, grade);
        model.addTutor(tutor);
        sc.close();
        return false;
    }
}
