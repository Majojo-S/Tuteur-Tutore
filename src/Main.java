import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

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
	private static final Point2D size = new Point2D(screenBounds.getWidth() - 100, screenBounds.getHeight() - 20);

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("ui/views/HomeView.fxml"));
		VBox root = loader.load();
		Scene scene = new Scene(root, size.getX(), size.getY());
		stage.setScene(scene);
		stage.setTitle(WIN_TITLE);
		stage.show();
	}
}
