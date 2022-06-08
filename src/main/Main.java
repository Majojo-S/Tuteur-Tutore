package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import reader.StudentCSVReader;
import terminal.Shell;
import terminal.command.exception.CommandNotFoundException;
import tutoring.Student;
import tutoring.tutor.Tutor;
import tutoring.tutored.Tutored;
import ui.model.Model;

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
            if (is instanceof Tutor) {
                tutors.add((Tutor) is);
            }
            if (is instanceof Tutored) {
                tutored.add((Tutored) is);
                System.out.println(is);
            }
        }

        Model m = Model.getInstance();
        m.setTutors(tutors);
        m.setTutored(tutored);

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
