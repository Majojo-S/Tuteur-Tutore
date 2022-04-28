package sae;

import java.util.ArrayList;
import java.util.List;

public class Tutored extends Student {
	List<Ressource> ressources;
	
	
	public Tutored(String fn, String ln) {
		super(fn,ln,1);
		ressources = new ArrayList<>();
	}
	
	public List<Ressource> getRessources() {
		return ressources;
	}
	public void setRessources(List<Ressource> ressources) {
		this.ressources = ressources;
	}
	
	
	
}
