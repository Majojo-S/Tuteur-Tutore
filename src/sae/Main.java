package sae;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import fr.ulille.but.sae2_02.graphes.GrapheNonOrienteValue;
import sae.graph.GraphGenerator;
import sae.graph.TutoringGraph;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import sae.reader.StudentCSVReader;
import sae.terminal.Shell;
import sae.exception.CommandNotFoundException;
import sae.tutoring.Resource;
import sae.tutoring.Student;
import sae.tutoring.tutor.Tutor;
import sae.tutoring.tutored.Tutored;
import sae.model.Model;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author marine.sandras.etu
 * @author simon.bocquet.etu The 09 mai 2022
 */
public class Main extends Application {

    private static final String WIN_TITLE = "SAE 2.01 & 2.02 Tuteurs et Tutorés";
    private static final Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    private static final Point2D size = new Point2D(656, 383);

    public static void main(String[] args) throws IOException, InterruptedException, CommandNotFoundException {

        File f = new File("res/data.csv");
        ArrayList<Student> students = StudentCSVReader.read(f);
        ArrayList<Tutor> tutors = new ArrayList<>();
        ArrayList<Tutored> tutored = new ArrayList<>();
        for (Student is : students) {
            if (is instanceof Tutor) tutors.add((Tutor) is);
            if (is instanceof Tutored) tutored.add((Tutored) is);
        }

        Model m = Model.getInstance();
        m.setTutors(tutors);
        m.setTutored(tutored);

        // TODO quentin 6/8/22: CODE HORRIBLE JUST HORRIBLE !!!!!!
        ArrayList<Student> tutorsAsStudent = new ArrayList<>(tutors);
        ArrayList<Student> tutoredAsStudent = new ArrayList<>(tutored);
        GrapheNonOrienteValue<Student> graph = new GraphGenerator(tutorsAsStudent, tutoredAsStudent, Resource.ALGO).createGraph();
        TutoringGraph.setGraph(graph);

        if (args.length > 0) {
            Application.launch(args);
        } else {
            Shell.launch();
        }

    }

    @Override
    public void start(Stage stage) throws Exception {
        File f = new File("res" + File.separator + "Interface.fxml");

        FXMLLoader loader = new FXMLLoader(f.toURI().toURL());
        System.out.println(loader.getLocation());
        VBox root = loader.load();
        Scene scene = new Scene(root, size.getX(), size.getY());
        stage.setScene(scene);
        stage.setTitle(WIN_TITLE);
        stage.show();
    }
}
