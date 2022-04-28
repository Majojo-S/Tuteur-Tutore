package tutoring;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 */
public class Person {

    private final String firstName;
    private String lastName;

    /**
     * Constructor
     * 
     * @param First name of person
     * @param Last name of person
     */
    public Person(String fn, String ln) {
        firstName = fn == null ? "" : fn;
        lastName = ln == null ? "" : ln;
    }

    /**
     * Get the First Name of person
     * @return First name of person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the Last Name of person
     * @return Last name of person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set Last Name of person
     * @param Last name of person
     */
    public void setLastName(String ln) {
        if (ln != null && ln.length() > 0) lastName = ln;
    }

}
