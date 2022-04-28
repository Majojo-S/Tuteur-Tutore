package tutoring;

public enum Resource {
    BDD(10), ALGO(5);

    final int limit;

    private Resource(int n) {
        limit = n;
    }
}
