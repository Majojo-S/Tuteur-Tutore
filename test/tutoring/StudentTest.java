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
        s1 = new Student("John1", "Doe1");
        s2 = new Student("John2", "Doe2", 2);
        s3 = new Student("", "Doe");
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
        assertEquals("", s3.getFirstName());
        s3 = new Student("John", "");
        assertEquals("", s3.getLastName());
    }
}
