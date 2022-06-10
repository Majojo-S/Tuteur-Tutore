package sae.terminal.command;

import fr.ulille.but.sae2_02.graphes.Arete;
import sae.tutoring.Student;

public class GraphCommand extends AbstractCommand implements ICommand {

    @Override
    public boolean execute() {
        for (Arete<Student> is : tutoringGraph.getGraph().aretes())
            System.out.println(is);
        return true;
    }
}
