package sae;

import java.util.List;

public class Tutor extends Student {
	private List<Tutored> tutored;
	private Ressource ressource;
	
	public Tutor(String fn, String ln, int studentLvl) {
		super(fn,ln,studentLvl);
	}
	
	public Tutor(String firstName, String lastName, Ressource r) {
		this(firstName, lastName, 2);
		ressource = r;
	}

	public Tutor(String firstName, String lastName) {
		this(firstName, lastName, 2);
	}

	public List<Tutored> getTutored() {
		return tutored;
	}

	public void setTutored(List<Tutored> tutored) {
		this.tutored = tutored;
	}

	public Ressource getRessource() {
		return ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}
	
}