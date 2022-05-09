package tutoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tutoring.teacher.Teacher;

class TeacherTest {

    private Teacher t1, t2;
    List<Resource> listR1, listR2;

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

    @Test
    void initTest() {
        assertEquals("A", t1.getFirstName());
        assertEquals("A", t1.getLastName());
        assertEquals("B", t2.getFirstName());
        assertEquals("B", t2.getLastName());
    }

    @Test
    void getResourceTest() {
        assertEquals(listR1, t2.getResources());
        assertEquals(listR2, t1.getResources());
    }

    @Test
    void setResourceTest() {
        assertEquals(listR1, t2.getResources());
        t2.setResources(listR1);
        assertEquals(listR1, t2.getResources());
        t1.setResources(listR2);
    }


    @Test
    void addResourceTest() {
        t1.addResource("Algo");
        assertEquals(listR1, t1.getResources());
        t1.addResource("notExists");
        assertEquals(listR1, t1.getResources());
    }


}
