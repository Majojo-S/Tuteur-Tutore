package sae.tutored;

import java.util.ArrayList;
import java.util.List;

import sae.tutoring.Resource;
import sae.tutoring.Student;

/**
 * A tutored student has a list of resources to be tutored
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 */
public class Tutored extends Student {

    private List<Resource> resources;

    /**
     * Create a Tutored Student
     *
     * @param firstName First name of tutored
     * @param lastName  Last name of tutored
     */
    public Tutored(String firstName, String lastName) {
        super(firstName, lastName, 1);
        resources = new ArrayList<>();
    }

    /**
     * Created a Tutored Student with a resource
     *
     * @param firstName First name of tutored
     * @param lastName  Last name of tutored
     * @param resource  Resource to be tutored
     */
    public Tutored(String firstName, String lastName, Resource resource) {
        this(firstName, lastName);
        this.resources.add(resource);
    }

    /**
     * Get List of resources
     *
     * @return List of resource of tutored
     */
    public List<Resource> getResources() {
        return resources;
    }

    /**
     * Set List of Resources
     *
     * @param resources List of resource
     */
    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    /**
     * Add a resource to the list
     *
     * @param resource Resource to add
     */
    public void addRessource(Resource resource) {
        resources.add(resource);
    }

    @Override
    public String toString() {
        return "Tutored: " + getFirstName() + " " + getLastName();
    }
}
