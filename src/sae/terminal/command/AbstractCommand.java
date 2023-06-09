package sae.terminal.command;

import sae.graph.TutoringGraph;
import sae.model.Model;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * The 31 mai 2022
 */
abstract public class AbstractCommand {

    protected static String COMMAND_NAME = "";
    protected static final Model model = Model.getInstance();
    protected static final TutoringGraph tutoringGraph = TutoringGraph.getInstance();

    protected String getCommandName() {
        return COMMAND_NAME;
    }

}
