package tutoring.tutored;

import tutoring.Resource;
import tutoring.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 */
public class Tutored extends Student {

    List<Resource> resources;
    
    /**
     * Create a Tutored Student
     * @param First name of tutored
     * @param Last name of tutored
     */
    public Tutored(String fn, String ln) {
        super(fn, ln, 1);
        resources = new ArrayList<>();
    }
    
    /**
     * Created a Tutored Student with a resource
     * @param fn
     * @param ln
     * @param r
     */
    public Tutored(String fn, String ln, Resource r) {
        this(fn,ln);
        this.resources.add(r);
    }

    /**
     * Get List of resources
     * @return List of resource of tutored
     */
    public List<Resource> getResources() {
        return resources;
    }

    /**
     * Set List of Resources
     * @param List of resource 
     */
    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }
    
    /**
     * Add a resource to the list
     * @param Resource 
     */
    public void addRessource(Resource r) {
    	resources.add(r);
    }
}
