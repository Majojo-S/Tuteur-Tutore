package graph;

import java.util.ArrayList;

import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;
import tutoring.Student;
import tutoring.tutor.Tutor;
import tutoring.tutored.Tutored;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author marine.sandras.etu
 * @author simon.bocquet.etu The 09 may 2022
 */
public class GraphGenerator {

	private static final ArrayList<Student> tutors = DataGenerator.tutors;
	private static final ArrayList<Student> tutored = DataGenerator.tutored;

	/*
	 * Create the graph
	 * 
	 * @return a graph with vertex and edge of a dataGenerator
	 */
	public static GrapheNonOrienteValue<Student> createGraph() {
		GrapheNonOrienteValue<Student> graph = new GrapheNonOrienteValue<>();
		DataGenerator.fillSizeDifference();
		addVertex(graph);
		makeEdge(graph);

		return graph;
	}

	/*
	 * add vertex to a graph
	 * 
	 * @param a graph non oriented and value of student
	 */
	private static void addVertex(GrapheNonOrienteValue<Student> graph) {
		for (Student tutor : tutors)
			graph.ajouterSommet(tutor);
		for (Student student : tutored)
			graph.ajouterSommet(student);
	}

	/*
	 * calculate the weight of the edge between the two student
	 * 
	 * @param a tutor
	 * 
	 * @param a tutored
	 * 
	 * @return the weight of the edge
	 */
	private static double calculateNodeWeight(Tutor t, Tutored td) {
		if (t == null)
			return 0;
		if (td == null)
			return 0;
		int max = 20;
		if (t.getStudyLevel() == 3)
			max -= 5;
		max -= (t.getAverage(t.getResource()) - td.getAverage(t.getResource()));
		return max;
	}

	/*
	 * do the edge between all the vertex of the graph
	 * 
	 * @param a graph non oriented and value of student
	 */
	private static void makeEdge(GrapheNonOrienteValue<Student> graph) {
		for (Student tutor : tutors) {
			for (Student tutored : tutored) {
				if (tutored.getFirstName().equals("null")) {
					graph.ajouterArete(tutor, tutored, 30);
				} else if (tutor.getFirstName().equals("D") && tutored.getFirstName().equals("Q")
						|| tutor.getFirstName().equals("E") && tutored.getFirstName().equals("N")) {
					graph.ajouterArete(tutor, tutored, 0);
				} else {
					graph.ajouterArete(tutor, tutored, calculateNodeWeight((Tutor) tutor, (Tutored) tutored));

				}
			}
		}
	}
}
