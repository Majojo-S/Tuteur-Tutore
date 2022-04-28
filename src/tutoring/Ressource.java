package sae;

public enum Ressource {
	BDD(10),ALGO(5);
	int limit;
	
	private Ressource(int n) {
		limit = n;
	}
}
