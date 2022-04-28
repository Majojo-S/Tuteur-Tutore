package sae;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
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

    /**
     * Get the Study Level
     * @return int
     */
    public int getStudyLevel() {
        return studyLevel;
    }

    /**
     * Set a new Study Level 
     * @param studyLevel int
     */
    public void setStudyLevel(int studyLevel) {
        this.studyLevel = studyLevel;
    }

    /**
     * Get the number of Absence
     * @return int
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
     * @param absence int
     */
    public void addAbsence(int absence) {
    	this.absence += absence;
    }
}
