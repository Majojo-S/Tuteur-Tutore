package ui.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import reader.StudentCSVReader;
import tutoring.Student;
import tutoring.tutor.Tutor;
import tutoring.tutored.Tutored;
import ui.model.Model;

/**
 * Project C-G3
 *
 * @author quentin.barlet.etu
 * @author marine.sandras.etu
 * @author simon.bocquet.etu The 13 mai 2022
 */
public final class Controller {
	private Model m;

	@FXML
	private ListView<Tutor> listTutor;
	@FXML
	private ListView<Tutored> listTutored;
	@FXML
	private Button addTutor;
	@FXML
	private Button removeTutor;
	@FXML
	private Button addTutored;
	@FXML
	private Button removeTutored;
	@FXML
	private Button searchButton;
	@FXML
	private Button notAffectedButton;
	@FXML
	private Button AffectTutor;
	@FXML
	private Slider resLimitSlider;
	@FXML
	private Label resLimitLabel;
	@FXML
	private TextField searchStudentField;
	@FXML
	private MenuItem loadCSV;
	private ListProperty<Tutor> lpTutor;
	private ListProperty<Tutored> lpTutored;

	public void initialize() {
		m = new Model();
		resLimitLabel.setText(""+m.getLimit());
		resLimitSlider.adjustValue((double) m.getLimit());
		lpTutor = new SimpleListProperty<>();
		lpTutored = new SimpleListProperty<>();
		m.addTutor("oui", "oui");
		m.addTutor("non", "non");
		m.addTutored("oui", "oui");
		m.addTutored("ha", "ha");
		lpTutor.set(FXCollections.observableArrayList(m.getTutors()));
		lpTutored.set(FXCollections.observableArrayList(m.getTutored()));
		listTutor.itemsProperty().bind(lpTutor);
		listTutored.itemsProperty().bind(lpTutored);
	}

	public void addTutor(ActionEvent event) {
		Popup popup = new Popup();
		popup.display(addTutor.getScene().getWindow(), "Add Tutor");
		
		lpTutor.set(FXCollections.observableArrayList(m.getTutors()));
	}

	public void removeTutor(ActionEvent event) {
		m.removeTutor(listTutor.getSelectionModel().getSelectedItem());
		lpTutor.set(FXCollections.observableArrayList(m.getTutors()));
	}

	public void addTutored(ActionEvent event) {

	}

	public void removeTutored(ActionEvent event) {
		m.removeTutored(listTutored.getSelectionModel().getSelectedItem());
		lpTutored.set(FXCollections.observableArrayList(m.getTutored()));
	}

	public void search(ActionEvent event) {
		String firstName = searchStudentField.getText().split(" ")[0];
		String lastNamename = searchStudentField.getText().split(" ")[1];
		Student search = new Student(firstName, lastNamename);
	}

	public void showNotAffected(ActionEvent event) {
		
	}

	public void affect(ActionEvent event) {

	}

	public void setResLimit(Event event) {
		m.setLimit((int) resLimitSlider.getValue());
		resLimitLabel.setText(""+m.getLimit());
	}
	
	public void loadCSV(ActionEvent event) {
		FileChooser fc = new FileChooser();
		List<Tutor> tutors = new ArrayList<Tutor>();
		List<Tutored> tutored = new ArrayList<Tutored>();
		for (Student stu : StudentCSVReader.read(fc.showOpenDialog(addTutor.getScene().getWindow()))) {
			if(stu.getClass().equals(Tutor.class))
				tutors.add((Tutor) stu);
			else
				tutored.add((Tutored) stu);
		}
		m.addTutor(tutors);
		m.addTutored(tutored);
		lpTutor.set(FXCollections.observableArrayList(m.getTutors()));
		lpTutored.set(FXCollections.observableArrayList(m.getTutored()));
	}
	
	

}
