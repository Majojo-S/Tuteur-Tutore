import fr.ulille.but.sae2_02.graphes.CalculAffectation;
import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;
import graph.DataGenerator;
import graph.GraphGenerator;
import tutoring.Student;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author marine.sandras.etu
 * @author simon.bocquet.etu
 * The 09 mai 2022
 */
public class Main {

    public static void main(String[] args) {

        GrapheNonOrienteValue<Student> graph = createGraph();
        System.out.println(DataGenerator.tutors.size());
        System.out.println(DataGenerator.tutored.size());

        CalculAffectation<Student> result = new CalculAffectation<>(graph, DataGenerator.tutors, DataGenerator.tutored);
        System.out.println(result.getAffectation());
    }

    private static GrapheNonOrienteValue<Student> createGraph() {
        return GraphGenerator.createGraph();
    }
}
