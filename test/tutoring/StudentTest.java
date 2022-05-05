package tutoring;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tutoring.Student;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 * The 04 of avril 2022
 */
public class StudentTest {

    private Student s1, s2, s3;

    @BeforeEach
    public void initialization() {
        s1 = new Student("StudentFirstName1", "StudentLastName1");
        s2 = new Student("StudentFirstName2", "studentLastName3", 2);
        s3 = new Student("", "StudentLastName3");
    }

    @Test
    public void validateStudentTest() {
    }

    @Test
    public void checkDefaultValueTest() {

        // Study Level
        assertEquals(1, s1.getStudyLevel());
        assertEquals(2, s2.getStudyLevel());

        // Absence
        assertEquals(0, s1.getAbsence());

        // Names
        assertEquals("john", s3.getFirstName());
        s3 = new Student("StudentFirstName3", "");
        assertEquals("doe", s3.getLastName());
    }
}
