package ui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author marine.sandras.etu
 * @author simon.bocquet.etu
 * The 13 mai 2022
 */
public final class HomeController extends AbstractController implements Initializable {

    @FXML
    private Button button;

    public void onClick(MouseEvent event) {
        System.out.println("Clicked");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
