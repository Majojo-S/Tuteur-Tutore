package sae.tutor;

import java.util.ArrayList;
import java.util.List;

import sae.tutored.Tutored;
import sae.tutoring.Resource;
import sae.tutoring.Student;

/**
 * A tutor is the same as a student with a list of tutored student and a resource to tutor
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 */
public class Tutor extends Student {

    private List<Tutored> tutored;
    private Resource resource;

    /**
     * Full Constructor
     *
     * @param firstName First Name of tutor
     * @param lastName  Last Name of tutor
     * @param resource  Student Level of tutor
     */
    public Tutor(String firstName, String lastName, int studentLvl, Resource resource) {
        super(firstName, lastName, studentLvl);
        this.resource = resource;
        this.tutored = new ArrayList<>();
    }

    /**
     * Constructor with first name, last name and student level of the tutor
     *
     * @param firstName  First Name of tutor
     * @param lastName   Last Name of tutor
     * @param studentLvl Student level of tutor
     */
    public Tutor(String firstName, String lastName, int studentLvl) {
        this(firstName, lastName, studentLvl, null);
    }

    /**
     * Updated
     * Constructor with first name last name and resource of tutor
     *
     * @param firstName First Name of tutor
     * @param lastName  Last Name of tutor
     * @param resource  Resource of tutor
     */
    public Tutor(String firstName, String lastName, Resource resource) {
        this(firstName, lastName, 2, resource);
    }

    /**
     * Constructor with first name and last name of tutor
     *
     * @param firstName first name
     * @param lastName  last name
     */
    public Tutor(String firstName, String lastName) {
        this(firstName, lastName, 2, null);
    }

    /**
     * Get list of tutored student for this tutor
     *
     * @return list of student to be tutored
     */
    public List<Tutored> getTutored() {
        return tutored;
    }

    /**
     * Set list of tutored student for this tutor
     *
     * @param tutored List of student to be tutored
     */
    public void setTutored(List<Tutored> tutored) {
        this.tutored = tutored;
    }

    /**
     * Get resource of tutor
     *
     * @return Resource of tutor
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * Set resource of tutor
     *
     * @param resource Resource of tutor
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    /**
     * Add a tutored to list of student to be tutored
     *
     * @param tutoredStudent tutored Student
     */
    public void addTutored(Tutored tutoredStudent) {
        tutored.add(tutoredStudent);
    }

    @Override
    public String toString() {
        return "Tutor: " + getFirstName() + " " + getLastName();
    }
}