package sae.tutoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests for student
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 * 
 */
public class StudentTest {

    private Student s1, s2, s3;

    /**
     * initialize students for each tests
     */
    @BeforeEach
    public void initialization() {
        s1 = new Student("John1", "Doe1");
        s2 = new Student("John2", "Doe2", 2);
        s3 = new Student("", "Doe");
    }

    /**
     * Test the validity of a student
     */
    @Test
    public void validateStudentTest() {
    }

    /**
     * Test the default values for the study level, the number of absences and the name of a student
     */
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
