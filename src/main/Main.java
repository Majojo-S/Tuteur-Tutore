package main;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import terminal.Shell;
import terminal.command.exception.CommandNotFoundException;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author marine.sandras.etu
 * @author simon.bocquet.etu The 09 mai 2022
 */
public class Main extends Application {

    private static final String      WIN_TITLE    = "SAE 2.01 & 2.02 Tuteurs et Tutorés";
    private static final Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    private static final Point2D     size         = new Point2D(656, 383);

    public static void main(String[] args) throws IOException, InterruptedException, CommandNotFoundException {

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
        VBox  root  = loader.load();
        Scene scene = new Scene(root, size.getX(), size.getY());
        stage.setScene(scene);
        stage.setTitle(WIN_TITLE);
        stage.show();
    }
}
