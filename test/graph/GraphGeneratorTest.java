package graph;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;

import fr.ulille.but.sae2_02.graphes.Arete;
import reader.StudentCSVReader;
import tutoring.Resource;
import tutoring.Student;
import tutoring.tutor.Tutor;
import tutoring.tutored.Tutored;

public class GraphGeneratorTest {

	private ArrayList<Student> list;
	private Map<Tutored, Tutor> couple;
	private ArrayList<Student> banned;
	private Resource r;
	private List<Arete<Student>> affectation;

	@BeforeEach
	public void init() {
		list = StudentCSVReader.read(new File("res/dataStudents.csv"));
		r = Resource.ALGO;
		GraphGenerator g = new GraphGenerator(list, r);
	}

}
