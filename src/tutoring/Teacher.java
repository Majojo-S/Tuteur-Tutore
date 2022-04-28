package teacher;
import java.util.ArrayList;
import java.util.List;

import sae.Person;
import sae.Ressource;
/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 */
public class Teacher extends Person {
	
	List<Ressource> ressources;
	
    /**
     * Create New Teacher with multiple ressources
     * @param firstName String
     * @param lastName  String
     * @param ressource List<Ressource>
     */
    public Teacher(String firstName, String lastName, List<Ressource> ressource) {
    	super(firstName, lastName);
    	this.ressources = ressource;
    }

    
    /**
     * Create new Teacher with 1 ressource
     * @param firstName String
     * @param lastName String
     * @param ressource Ressource
     */
    public Teacher(String firstName, String lastName, Ressource ressource) {
    	super(firstName, lastName);
    	ressources = new ArrayList<>();
    	ressources.add(ressource);
    }
    
    /**
     * Get ressource
     * @return Ressource
     */
	public List<Ressource> getRessources() {
		return ressources;
	}

	/**
	 * Set new Ressources
	 * @param ressource Ressource
	 */
	public void setRessources(List<Ressource> ressources) {
		this.ressources = ressources;
	}

	/**
	 * Add a new Ressource
	 * @param ressource
	 */
    public void addRessource(String ressource) {
    	if(Ressource.valueOf(ressource)!=null)
    		ressources.add(Ressource.valueOf(ressource));
    }
    
}
