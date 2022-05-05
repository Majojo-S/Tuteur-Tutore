package graph;

import java.util.ArrayList;
import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;
import tutoring.Resource;
import tutoring.Student;
import tutoring.Tutor;
import tutoring.Tutored;

public class Affectation {

	
	private static ArrayList<Student> tutor = new ArrayList<Student>();
	private static ArrayList<Student> tutored = new ArrayList<Student>();
	static ArrayList<Student> list = init();
	
	
	static void makeTheTwoList() {
		for(int i=0;i<list.size();++i) {
			if(list.get(i).getStudyLevel()== 1) {
				tutored.add(list.get(i));
			}else {
				tutor.add(list.get(i));
			}
		}
		verifiedtaille();
	}
	
	private static void verifiedtaille() {
		if(tutor.size()<tutored.size()) {
			//rajouter en double tutor 3e année jusqu'à atteindre la taille de tutored
		}else if(tutored.size()<tutor.size()) {
			//rajouter des tutored null avec poid énorme
		}
	}

	static GrapheNonOrienteValue<Student> createGraph() {
		GrapheNonOrienteValue<Student> graph = new GrapheNonOrienteValue<Student>();
		for(int i=0;i<list.size();++i) graph.ajouterSommet(list.get(i));
		for(int t=0;t<tutor.size();++t) {
			for(int td=0;td<tutored.size();++td) {
				graph.ajouterArete(tutor.get(t), tutored.get(td), makeWeigth((Tutor)tutor.get(t), (Tutored)tutored.get(td)));
			}
		}
		
		return graph;
	}
	
	static double makeWeigth(Tutor t, Tutored td) {
		int max = 20;
		if(t.getStudyLevel()==3) {
			max -= 5;
		}
		max -= (t.getAverage(t.getResource())-td.getAverage(t.getResource()));
		return max;
	}

	
	public static void main(String[] args) {
		
		makeTheTwoList();
		GrapheNonOrienteValue<Student> graph = createGraph();
		
		
		
		

	}
	
	private static ArrayList<Student> init(){
		
		ArrayList<Student> data = new ArrayList<Student>();
		Resource matiere = Resource.BDD;
		
		Tutor A = new Tutor("A", "A", 2,matiere);
		A.addGrade(matiere, 16.2);
		Tutor B = new Tutor("B", "B", 3,matiere);
		B.addGrade(matiere, 15.3);
		Tutor C = new Tutor("C", "C", 2,matiere);
		C.addGrade(matiere, 15.6);
		Tutor D = new Tutor("D", "D", 3,matiere);
		D.addGrade(matiere, 18.2);
		Tutor E = new Tutor("E", "E", 3,matiere);
		E.addGrade(matiere, 14.9);
		Tutored L = new Tutored("L", "L",matiere);
		L.addGrade(matiere, 10.1);
		Tutored M = new Tutored("M", "M",matiere);
		M.addGrade(matiere, 4.7);
		Tutored N = new Tutored("N", "N",matiere);
		N.addGrade(matiere, 9.8);
		Tutored O = new Tutored("O", "O",matiere);
		O.addGrade(matiere, 8.6);
		Tutored P = new Tutored("P", "P",matiere);
		P.addGrade(matiere, 6.5);
		Tutored Q = new Tutored("Q", "Q",matiere);
		Q.addGrade(matiere, 8.9);
		Tutored R = new Tutored("R", "R",matiere);
		R.addGrade(matiere, 11.0);
		
		data.add(A);
		data.add(B);
		data.add(M);
		data.add(L);
		data.add(D);
		data.add(N);
		data.add(Q);
		data.add(E);
		data.add(C);
		data.add(P);
		data.add(R);
		data.add(O);
		
		return data;
	}
}
