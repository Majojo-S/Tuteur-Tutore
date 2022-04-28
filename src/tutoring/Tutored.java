package tutoring;

import java.util.ArrayList;
import java.util.List;

public class Tutored extends Student {

    List<Resource> resources;

    public Tutored(String fn, String ln) {
        super(fn, ln, 1);
        resources = new ArrayList<>();
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

}
