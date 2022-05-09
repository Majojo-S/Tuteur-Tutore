package tutoring.tutor;

import tutoring.Resource;
import tutoring.Student;
import tutoring.tutored.Tutored;

import java.util.ArrayList;
import java.util.List;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 */
public class Tutor extends Student {

    public static ArrayList<Student> tutors = new ArrayList<>();
    private List<Tutored> tutored;
    private Resource resource;

    /**
     * Full Constructor
     *
     * @param fn         name of tutor
     * @param ln         name of tutor
     * @param studentLvl level of tutor
     * @param r          resource
     */
    public Tutor(String fn, String ln, int studentLvl, Resource r) {
        super(fn, ln, studentLvl);
        resource = r;
        tutored = new ArrayList<>();
    }

    /**
     * Constructor with first name, last name and student level of the tutor
     *
     * @param fn         name of tutor
     * @param ln         name of tutor
     * @param studentLvl level of tutor
     */
    public Tutor(String fn, String ln, int studentLvl) {
        this(fn, ln, studentLvl, null);
    }

    /**
     * Constructor with first name last name and resource of tutor
     *
     * @param firstName name of tutor
     * @param lastName  name of tutor
     * @param r         resource
     */
    public Tutor(String firstName, String lastName, Resource r) {
        this(firstName, lastName, 2, r);
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
     * @param tutored list of student to be tutored
     */
    public void setTutored(List<Tutored> tutored) {
        this.tutored = tutored;
    }

    /**
     * Get resource of tutor
     *
     * @return resource of tutor
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * Set resource of tutor
     *
     * @param resource of tutor
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    /**
     * Add a tutored to list of student to be tutored
     *
     * @param t tutor
     */
    public void addTutored(Tutored t) {
        tutored.add(t);
    }

}