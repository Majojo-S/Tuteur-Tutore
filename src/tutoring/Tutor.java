package tutoring;

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

    private List<Tutored> tutored;
    private Resource resource;
    /**
     * Full Constructor
     * @param First Name of tutor
     * @param Last Name of tutor
     * @param Student Level of tutor
     */
    public Tutor(String fn, String ln, int studentLvl, Resource r) {
    	super(fn,ln,studentLvl);
    	resource = r;
    	tutored = new ArrayList<>();
    }
    
    /**
     * Constructor with first name, last name and student level of the tutor
     * @param First Name of tutor
     * @param Last Name of tutor
     * @param Student level of tutor
     */
    public Tutor(String fn, String ln, int studentLvl) {
        this(fn, ln, studentLvl, null);
    }

    /**
     * Constructor with first name last name and resource of tutor
     * @param First Name of tutor
     * @param Last Name of tutor
     * @param Resource of tutor
     */
    public Tutor(String firstName, String lastName, Resource r) {
        this(firstName, lastName, 2, r);
    }

    /**
     * Constructor with first name and last name of tutor
     * @param firstName
     * @param lastName
     */
    public Tutor(String firstName, String lastName) {
        this(firstName, lastName, 2, null);
    }

    /**
     * Get list of tutored student for this tutor
     * @return list of student to be tutored
     */
    public List<Tutored> getTutored() {
        return tutored;
    }

    /**
     * Set list of tutored student for this tutor
     * @param list of student to be tutored
     */
    public void setTutored(List<Tutored> tutored) {
        this.tutored = tutored;
    }

    /**
     * Get resource of tutor
     * @return resource of tutor
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * Set resource of tutor
     * @param resource of tutor
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }
    
    /**
     * Add a tutored to list of student to be tutored
     * @param tutored
     */
    public void addTutored(Tutored t) {
    	tutored.add(t);
    }
    
}