package teacher;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 * The 25 of avril 2022
 */
public class Teacher {

    private final String firstName;
    private final String lastName;

    /**
     * @param firstName String
     * @param lastName  String
     */
    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
