package sae;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 * The 04 of avril 2022
 */
public class Student {

    private String lastName;
    private String firstName;
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

        if (0 == firstName.length() || 0 == lastName.length()) return;
        if (studyLevel < 0) return;

        this.firstName = firstName;
        this.lastName = lastName;
        this.studyLevel = studyLevel;
        this.absence = 0;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
