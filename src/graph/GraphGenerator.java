package graph;

import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;
import tutoring.Student;
import tutoring.tutor.Tutor;
import tutoring.tutored.Tutored;

import java.util.ArrayList;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author marine.sandras.etu
 * @author simon.bocquet.etu
 * The 09 mai 2022
 */
public class GraphGenerator {

    private static final ArrayList<Student> tutors = DataGenerator.tutors;
    private static final ArrayList<Student> tutored = DataGenerator.tutored;


    public static GrapheNonOrienteValue<Student> createGraph() {
        GrapheNonOrienteValue<Student> graph = new GrapheNonOrienteValue<>();
        DataGenerator.fillSizeDifference();
        addVertex(graph);
        makeEdge(graph);

        return graph;
    }

    private static void addVertex(GrapheNonOrienteValue<Student> graph) {
        for (Student tutor : tutors)
            graph.ajouterSommet(tutor);
        for (Student student : tutored)
            graph.ajouterSommet(student);
    }

    private static double calculateNodeWeight(Tutor t, Tutored td) {
        if (t == null) return 0;
        if (td == null) return 0;
        int max = 20;
        if (t.getStudyLevel() == 3) max -= 5;
        max -= (t.getAverage(t.getResource()) - td.getAverage(t.getResource()));
        return max;
    }

    private static void makeEdge(GrapheNonOrienteValue<Student> graph) {
        for (Student tutor : tutors) {
            for (Student tutored : tutored) {
                if (tutored.getFirstName().equals("null")) {
                    graph.ajouterArete(tutor, tutored, 30);
                } else if (tutor.getFirstName().equals("D") && tutored.getFirstName().equals("Q") || tutor.getFirstName().equals("E") && tutored.getFirstName().equals("N")) {
                    graph.ajouterArete(tutor, tutored, 0);
                } else {
                    graph.ajouterArete(tutor, tutored, calculateNodeWeight((Tutor) tutor, (Tutored) tutored));

                }
            }
        }
    }
}
