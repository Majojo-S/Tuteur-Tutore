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
public class Teacher extends Person {

    List<Resource> resources;

    /**
     * Create New Teacher with multiple resources
     *
     * @param First name of teacher
     * @param Last name of teacher
     * @param List of resource of the teacherr
     */
    public Teacher(String firstName, String lastName, List<Resource> resource) {
        super(firstName, lastName);
        this.resources = resource;
    }

    /**
     * Create new Teacher with 1 ressource
     *
     * @param First name of teacher
     * @param Last name of teacher
     * @param resource of teacher
     */
    public Teacher(String firstName, String lastName, Resource ressource) {
        super(firstName, lastName);
        resources = new ArrayList<>();
        resources.add(ressource);
    }

    /**
     * Return a list of resources that the teacher teach
     *
     * @return list of resource of teacher
     */
    public List<Resource> getResources() {
        return resources;
    }

    /**
     * Set the list of resources the teacher can teach
     *
     * @param resources Resource
     */
    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    /**
     * Add a new Resource
     *
     * @param resource String
     */
    public void addResource(String resource) {
        if (Resource.valueOf(resource) != null) resources.add(Resource.valueOf(resource));
    }

}
