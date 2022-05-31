package tutoring;

/**
 * List of courses
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 */
public enum Resource {
	BDD("Base de donnée", 30, 11), ALGO("Algorithmie", 30, 13), SYSTEM("Système", 30, 10);

	final String name;
	int limit;
	double averageMax;

	Resource(String name, int limit, double averageMax) {
		this.name = name;
		this.limit = limit;
		this.averageMax = averageMax;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public void setAverageMax(double average) {
		averageMax = average;
	}

}
