package tutoring;

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
}
