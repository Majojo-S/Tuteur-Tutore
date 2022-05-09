package tutoring.teacher;

import tutoring.Person;
import tutoring.Resource;

import java.sql.Array;
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

    public static ArrayList<Teacher> teachers = new ArrayList<>();
    private List<Resource> resources;

    /**
     * Create new Teacher with 1 ressource
     *
     * @param firstName name of teacher
     * @param lastName  name of teacher
     * @param resource  of teacher
     */
    public Teacher(String firstName, String lastName, Resource resource) {
        super(firstName, lastName);
        resources = new ArrayList<>();
        resources.add(resource);
    }

    /**
     * Create New Teacher with multiple resources
     *
     * @param firstName name of teacher
     * @param lastName  name of teacher
     * @param resources of resource of the teacherr
     */
    public Teacher(String firstName, String lastName, List<Resource> resources) {
        super(firstName, lastName);
        this.resources = resources;
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
        for (Resource r : Resource.values()) {
            if (r.name().equals(resource.toUpperCase())) resources.add(r);
        }
    }

}
