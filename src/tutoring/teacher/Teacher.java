package tutoring.teacher;

import java.util.ArrayList;
import java.util.List;

import tutoring.Person;
import tutoring.Resource;

/**
 * A teacher is the same as a person with a list of resources
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 */
public class Teacher extends Person {

	private List<Resource> resources;

	/**
	 * Create new Teacher with 1 resource
	 *
	 * @param firstName First name of teacher
	 * @param lastName  Last name of teacher
	 * @param resource  resource of teacher
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
	 * @param resources of resource of the teacher
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
	 * @param resources List of resources to affect to the teacher
	 */
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	/**
	 * Add a new Resource
	 *
	 * @param resource Resource to add
	 */
	public void addResource(String resource) {
		for (Resource res : Resource.values()) {
			if (res.name().equals(resource.toUpperCase()))
				resources.add(res);
		}
	}

}
