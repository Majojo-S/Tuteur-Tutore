package tutoring;

/**
 * List of courses
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 */
public enum Resource {
    BDD("Base de donnée", 30), ALGO("Algorithmie", 30), SYSTEM("Système", 30), IHM("Interface Homme-Machine", 20);

    final String name;
    int limit;
    double averageMax;
    Resource(String name, int limit) {
        this.name = name;
        this.limit = limit;
    }
    
    public String getName() {
    	return name;
    }
    
    public int getLimit() {
    	return limit;
    }
    
    public void setLimit(int limit) {
    	this.limit = limit;
    }
    
	public void setAverageMax(double average) {
		averageMax = average;
	}

	public double getAverageMax() {
		return averageMax;
	}
}
