package sae.graph;

import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;
import sae.tutoring.Student;

public class TutoringGraph {

    private static TutoringGraph tutoringGraph;
    private static GrapheNonOrienteValue<Student> graph;

    private TutoringGraph() {
    }

    public static void setGraph(GrapheNonOrienteValue<Student> t_graph) {
        graph = t_graph;
    }

    public GrapheNonOrienteValue<Student> getGraph() {
        return graph;
    }

    public static TutoringGraph getInstance() {
        if (tutoringGraph == null)
            tutoringGraph = new TutoringGraph();
        return tutoringGraph;
    }
}
