package tutoring;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 */
public class Student extends Person {

    private int studyLevel;
    private int absence;
    private Map<Resource, Double> grades;

    /**
     * Complete constructor with level parameter
     *
     * @param First name of Student
     * @param Last  name of Student
     * @param Study level of Student
     */
    public Student(String firstName, String lastName, int studyLevel) {
        super(firstName, lastName);
        this.studyLevel = (studyLevel <= 0) ? 1 : studyLevel;
        this.absence = 0;
        grades = new HashMap<>();
    }

    /**
     * Default constructor
     *
     * @param First name of Student
     * @param Last  name of Student
     */
    public Student(String firstName, String lastName) {
        this(firstName, lastName, 1);
    }

    /**
     * Get the Study Level
     *
     * @return Study level of Student
     */
    public int getStudyLevel() {
        return studyLevel;
    }

    /**
     * Set a new Study Level
     *
     * @param Study level of Student
     */
    public void setStudyLevel(int studyLevel) {
        this.studyLevel = studyLevel;
    }

    /**
     * Get the number of Absence
     *
     * @return Number of absences
     */
    public int getAbsence() {
        return absence;
    }

    /**
     * Add an Hour of absence
     */
    public void addAbsence() {
        absence++;
    }

    /**
     * Add n hours of absence
     *
     * @param absence int
     */
    public void addAbsence(int absence) {
        this.absence += absence;
    }

    /**
     * Add a grade
     *
     * @param resource
     * @param grade
     */
    public void addGrade(Resource resource, double grade) {
        if (resource != null && (grade >= 0 && grade <= 20)) grades.put(resource, grade);
    }

    /**
     * get average for a resource
     *
     * @param r
     * @return average for a resource
     */
    public double getAverage(Resource r) {
        return grades.get(r);
    }

    /**
     * get overall average
     *
     * @return overall average
     */
    public double getOverallAverage() {
        double res = 0;
        for (double truc : grades.values()) {
            res += truc;
        }
        return res / grades.size();
    }

    public void printGrades() {
        for (Map.Entry<Resource, Double> item : grades.entrySet()) {
            System.out.println("- " + item.getKey() + " : " + item.getValue());
        }
    }

    @Override
    public String toString() {
        return "Student: " + super.toString();
    }
}
