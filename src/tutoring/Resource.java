package tutoring;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 */
public enum Resource {
    BDD(10), ALGO(5);

    final int limit;

    private Resource(int n) {
        limit = n;
    }
}
