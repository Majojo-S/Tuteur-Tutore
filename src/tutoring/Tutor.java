package tutoring;

import java.util.List;

public class Tutor extends Student {

    private List<Tutored> tutored;
    private Resource resource;

    public Tutor(String fn, String ln, int studentLvl) {
        super(fn, ln, studentLvl);
    }

    public Tutor(String firstName, String lastName, Resource r) {
        this(firstName, lastName, 2);
        resource = r;
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

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

}