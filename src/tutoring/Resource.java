package tutoring;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 */
public enum Resource {
    BDD("Base de donnée", 30), ALGO("Algorithmie", 30), SYSTEM("Système", 30);

    final String name;
    final int limit;

    Resource(String name, int limit) {
        this.name = name;
        this.limit = limit;
    }
}
