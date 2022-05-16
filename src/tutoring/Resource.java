package tutoring;

/**
 * List of courses
 *
 * @author quentin.barlet.etu
 * @author simon.bocquet.etu
 * @author marine.sandras.etu
 */
public enum Resource {
    BDD(10), ALGO(5), MATHS(8);

    final int limit;

    private Resource(int limit) {
        this.limit = limit;
    }
}
