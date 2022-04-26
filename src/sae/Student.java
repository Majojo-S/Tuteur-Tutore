package sae;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 * The 04 of avril 2022
 */
public class Student extends Person{

    private int studyLevel;
    private int absence;

    /**
     * Default constructor
     *
     * @param firstName String
     * @param lastName  String
     */
    public Student(String firstName, String lastName) {
        this(firstName, lastName, 1);
    }

    /**
     * Complete constructor with level parameter
     *
     * @param firstName  String
     * @param lastName   String
     * @param studyLevel int
     */
    public Student(String firstName, String lastName, int studyLevel) {
    	super(firstName, lastName);
        this.studyLevel = (studyLevel <= 0) ? 1 : studyLevel;

        this.absence = 0;
    }

    public int getStudyLevel() {
        return studyLevel;
    }

    public void setStudyLevel(int studyLevel) {
        this.studyLevel = studyLevel;
    }

    public int getAbsence() {
        return absence;
    }

    public void setAbsence(int absence) {
        this.absence = absence;
    }
}
