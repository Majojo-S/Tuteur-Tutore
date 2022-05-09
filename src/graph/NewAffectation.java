package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import fr.ulille.but.sae2_02.graphes.CalculAffectation;
import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;
import tutoring.Resource;
import tutoring.Student;
import tutoring.Tutor;
import tutoring.Tutored;

public class NewAffectation {

	private static ArrayList<Student> tutors = new ArrayList<>();
	private static ArrayList<Student> tutored = new ArrayList<>();
	static ArrayList<Student> data = init();

	public static void main(String[] args) {

		makeTheTwoLists();
		GrapheNonOrienteValue<Student> graph = createGraph();

		System.out.println(tutors.size());
		System.out.println(tutored.size());
		CalculAffectation<Student> result = new CalculAffectation<>(graph, tutors, tutored);
		System.out.println(result.getAffectation().toString());
	}

	private static void makeTheTwoLists() {
		for (Student s : data) {
			if (s.getStudyLevel() == 1) {
				tutored.add(s);
			} else {
				tutors.add(s);
			}
		}
	}

	private static void fillSizeDifference(GrapheNonOrienteValue<Student> g) {
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
				Tutor t = new Tutor(s.getFirstName() + "2", s.getLastName(), 3, Resource.BDD);
				t.addGrade(Resource.BDD, s.getAverage(Resource.BDD));
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

	private static GrapheNonOrienteValue<Student> createGraph() {
		GrapheNonOrienteValue<Student> graph = new GrapheNonOrienteValue<>();
		fillSizeDifference(graph);
		addSommet(graph);
		doTheArete(graph, tutors, tutored);
		return graph;
	}

	private static void addSommet(GrapheNonOrienteValue<Student> graph) {
		for (Student tutor : tutors)
			graph.ajouterSommet(tutor);
		for (Student student : tutored)
			graph.ajouterSommet(student);
	}

	private static void doTheArete(GrapheNonOrienteValue<Student> graph, ArrayList<Student> t, ArrayList<Student> td) {
		for (Student tutor : tutors) {
			for (Student student : tutored) {
				if (student.getFirstName().equals("null")) {
					graph.ajouterArete(tutor, student, 30);
				} else {
					graph.ajouterArete(tutor, student, calculateNodeWeight((Tutor) tutor, (Tutored) student));

				}
			}
		}
	}

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

	/**
	 * Créer la liste des tuteurs et des tutorés (noeuds)
	 *
	 * @return ArrayList<Student>
	 */
	private static ArrayList<Student> init() {

		ArrayList<Student> data = new ArrayList<>();
		Resource matiere = Resource.BDD;

		// Tutors : 5 items
		Tutor A = new Tutor("A", "A", 2, matiere);
		A.addGrade(matiere, 16.2);
		Tutor B = new Tutor("B", "B", 3, matiere);
		B.addGrade(matiere, 15.3);
		Tutor C = new Tutor("C", "C", 2, matiere);
		C.addGrade(matiere, 15.6);
		Tutor D = new Tutor("D", "D", 3, matiere);
		D.addGrade(matiere, 18.2);
		Tutor E = new Tutor("E", "E", 3, matiere);
		E.addGrade(matiere, 14.9);

		// Tutored : 7 items
		Tutored L = new Tutored("L", "L", matiere);
		L.addGrade(matiere, 10.1);
		Tutored M = new Tutored("M", "M", matiere);
		M.addGrade(matiere, 4.7);
		Tutored N = new Tutored("N", "N", matiere);
		N.addGrade(matiere, 9.8);
		Tutored O = new Tutored("O", "O", matiere);
		O.addGrade(matiere, 8.6);
		Tutored P = new Tutored("P", "P", matiere);
		P.addGrade(matiere, 6.5);
		Tutored Q = new Tutored("Q", "Q", matiere);
		Q.addGrade(matiere, 8.9);
		Tutored R = new Tutored("R", "R", matiere);
		R.addGrade(matiere, 11.0);

		data.add(A);
		data.add(B);
		data.add(C);
		data.add(D);
		data.add(E);
		// Tutored
		data.add(L);
		data.add(M);
		data.add(N);
		data.add(Q);
		data.add(P);
		data.add(R);
		data.add(O);

		return data;
	}

	private static void printList(ArrayList<Student> l) {
		for (Student s : l)
			System.out.println(l);
	}
}
