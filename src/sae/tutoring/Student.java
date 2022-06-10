package sae.tutoring;

import java.util.HashMap;
import java.util.Map;

/**
 * A student is the same as a person with a number of absences, a study level
 * and grades
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 */
public class Student extends Person {

    private int studyLevel;
    private int absence;
    private final Map<Resource, Double> grades;

    /**
     * Complete constructor with level parameter
     *
     * @param firstName  First name of Student
     * @param lastName   Last name of Student
     * @param studyLevel Study level of Student
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
     * @param firstName First name of Student
     * @param lastName  Last name of Student
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
     * @param studyLevel Study level of Student
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
     * @param absence Number of absences to add
     */
    public void addAbsence(int absence) {
        this.absence += absence;
    }

    /**
     * Add a grade for a specific resource
     *
     * @param resource Resource to add a grade to
     * @param grade    A grade
     */
    public void addGrade(Resource resource, double grade) {
        if (resource != null && grade >= 0 && grade <= 20) grades.put(resource, grade);
    }

    /**
     * Get average for a resource
     *
     * @param resource Resource to get the average grade
     * @return average for a resource
     */
    public double getAverage(Resource resource) {
        if (grades.containsKey(resource)) return grades.get(resource);
        return 0.0;
    }

    /**
     * Get overall average
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

    /**
     * Print all grades
     */
    public void printGrades() {
        for (Map.Entry<Resource, Double> item : grades.entrySet()) {
            System.out.println("- " + item.getKey() + " : " + item.getValue());
        }
    }

    public Map<Resource, Double> getGrade() {
        return grades;
    }

    /**
     * Print student's first and last name
     */
    @Override
    public String toString() {
        return "Student( " + super.toString() + ")";
    }
}
