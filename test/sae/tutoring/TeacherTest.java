package sae.tutoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sae.tutoring.teacher.Teacher;

/**
 * Tests for teacher
 * 
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 */
public class TeacherTest {

	private Teacher t1, t2;
	private List<Resource> listR1, listR2;

	/**
	 * Initialize teachers for each tests
	 */
	@BeforeEach
	void initilization() {
		t1 = new Teacher("A", "A", Resource.BDD);
		listR1 = new ArrayList<>();
		listR1.add(Resource.BDD);
		listR1.add(Resource.ALGO);
		listR2 = new ArrayList<>();
		listR2.add(Resource.BDD);
		t2 = new Teacher("B", "B", listR1);
	}

	/**
	 * Test the initialization
	 */
	@Test
	void initTest() {
		assertEquals("A", t1.getFirstName());
		assertEquals("A", t1.getLastName());
		assertEquals("B", t2.getFirstName());
		assertEquals("B", t2.getLastName());
	}

	/**
	 * Test the getResource method
	 */
	@Test
	void getResourceTest() {
		assertEquals(listR1, t2.getResources());
		assertEquals(listR2, t1.getResources());
	}

	/**
	 * Test the setResource method
	 */
	@Test
	void setResourceTest() {
		assertEquals(listR1, t2.getResources());
		t2.setResources(listR1);
		assertEquals(listR1, t2.getResources());
		t1.setResources(listR2);
	}

	/**
	 * Test adding resource to teacher
	 */
	@Test
	void addResourceTest() {
		t1.addResource("Algo");
		assertEquals(listR1, t1.getResources());
		t1.addResource("notExists");
		assertEquals(listR1, t1.getResources());
	}
}
