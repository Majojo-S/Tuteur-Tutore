package sae.tutoring;

/**
 * Person characterized by it's first and last name 
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
     * @param firstName First name of person
     * @param lastName Last name of person
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName == null ? "" : firstName;
        this.lastName = lastName == null ? "" : lastName;
    }

    /**
     * Get the First Name of person
     *
     * @return First name of person
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the Last Name of person
     *
     * @return Last name of person
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set Last Name of person
     * @param lastName Last name of person
     */
    public void setLastName(String lastName) {
        if (lastName != null && lastName.length() > 0) this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " : " + lastName;
    }
}
