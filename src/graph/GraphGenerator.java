package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import fr.ulille.but.sae2_02.graphes.Arete;
import fr.ulille.but.sae2_02.graphes.CalculAffectation;
import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;
import tutoring.Resource;
import tutoring.Student;
import tutoring.tutor.Tutor;
import tutoring.tutored.Tutored;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author marine.sandras.etu
 * @author simon.bocquet.etu The 24 may 2022
 */
public class GraphGenerator {

	private ArrayList<Student> tutors;
	private ArrayList<Student> tutored;
	private Map<Tutored, Tutor> couple;
	private ArrayList<Student> banned;
	private Resource r;
	private List<Arete<Student>> affectation;

	public GraphGenerator(ArrayList<Student> tutors, ArrayList<Student> tutored, Map<Tutored, Tutor> couple,
			ArrayList<Student> banned, Resource r) {
		this.tutors = tutors;
		this.tutored = tutored;
		this.couple = couple;
		this.banned = banned;
		this.r = r;
	}

	/*
	 * Create the graph
	 * 
	 * @return a graph with vertex and edge of a dataGenerator
	 */
	public GrapheNonOrienteValue<Student> createGraph() {
		GrapheNonOrienteValue<Student> graph = new GrapheNonOrienteValue<>();
		removeBanned();
		fillSizeDifference();
		addVertex(graph);
		makeEdge(graph);

		return graph;
	}

	/*
	 * Remove students who banned
	 */
	private void removeBanned() {
		for (Student s : banned) {
			if (tutors.contains(s)) {
				tutors.remove(s);
			}
			if (tutored.contains(s)) {
				tutored.remove(s);
			}
		}

	}

	/*
	 * add vertex to a graph
	 * 
	 * @param a graph non oriented and value of student
	 */
	private void addVertex(GrapheNonOrienteValue<Student> graph) {
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
	private double calculateNodeWeight(Tutor t, Tutored td) {
		if (t == null)
			return 0;
		if (td == null)
			return 0;
		int max = 20;
		if (t.getStudyLevel() == 3)
			max -= 5;
		max -= (t.getAverage(r) - td.getAverage(r));
		return max;
	}

	/*
	 * do the edge between all the vertex of the graph
	 * 
	 * @param a graph non oriented and value of student
	 */
	private void makeEdge(GrapheNonOrienteValue<Student> graph) {
		for (Student tutor : tutors) {
			for (Student tutored : tutored) {
				if (tutored.getFirstName().equals("null")) {
					graph.ajouterArete(tutor, tutored, 30);
					// TODO marine 17.05.2022 : access to hash map of couple
				} else if (couple.containsKey(tutored) && couple.get(tutored).equals(tutor)) {
					graph.ajouterArete(tutor, tutored, 0);
				} else {
					graph.ajouterArete(tutor, tutored, calculateNodeWeight((Tutor) tutor, (Tutored) tutored));

				}
			}
		}
	}

	/*
	 * fill the list of tutor or tutored if one of them have different size to make
	 * it the same size
	 * 
	 */
	public void fillSizeDifference() {
		if (tutors.size() < tutored.size()) {
			// rajouter en double tutor 3e année jusqu'à atteindre la taille des tutored
			List<Student> thirdStudyLevelStudents = tutors.stream().filter(new Predicate<Student>() {
				@Override
				public boolean test(Student s) {
					return s.getStudyLevel() == 3;
				}
			}).collect(Collectors.toList());
//            System.out.println(thirdStudyLevel.size()); // 3
			int sizeDifference = tutored.size() - tutors.size();
			for (int i = 0; i < sizeDifference; ++i) {
				Student s = thirdStudyLevelStudents.get(i % thirdStudyLevelStudents.size());
				Tutor t = new Tutor(s.getFirstName() + "2", s.getLastName(), 3, r);
				t.addGrade(r, s.getAverage(r));
				tutors.add(t);
			}
		} else {
			// rajouter des tutored null avec des poids énormes
			for (int i = tutored.size(); i < tutors.size(); ++i) {
				Tutored s = new Tutored("null", "null");
				tutored.add(s);
			}
		}
	}

	/*
	 * do the affectation of the graph
	 * 
	 * @param GrapheNonOrienteValue<Student> g
	 * 
	 * @param List<Student> tutor
	 * 
	 * @param List<Student> tutored
	 * 
	 * @return the list of edges who is affected List<Arete<Student>>
	 * 
	 */
	public List<Arete<Student>> doTheAffectation(GrapheNonOrienteValue<Student> g, List<Student> tutor,
			List<Student> tutored) {
		CalculAffectation<Student> calcul = new CalculAffectation<Student>(g, tutor, tutored);
		return calcul.getAffectation();
	}

	/*
	 * couples who are affected
	 * 
	 * @return the string String
	 * 
	 */
	public String toString() {
		String res = "";
		for (Arete<Student> arete : affectation) {
			res += arete.getExtremite1().toString() + " - " + arete.getExtremite2().toString() + "\n";
		}
		return res;
	}

}
