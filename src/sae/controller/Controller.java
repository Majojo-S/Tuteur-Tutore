package sae.controller;

import java.io.File;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import sae.model.Model;
import sae.reader.StudentCSVReader;
import sae.tutor.Tutor;
import sae.tutored.Tutored;
import sae.tutoring.Student;

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
	private Button affectTutorButton;
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
		m = Model.getInstance();
		resLimitLabel.setText("" + m.getLimit());
		resLimitSlider.adjustValue((double) m.getLimit());
		lpTutor = new SimpleListProperty<>();
		lpTutored = new SimpleListProperty<>();
		m.addTutor("oui", "oui");
		m.addTutor("non", "non");
		m.addTutored("oui", "oui");
		m.addTutored("ha", "ha");
		lpTutor.set(FXCollections.observableList(m.getTutors()));
		lpTutored.set(FXCollections.observableList(m.getTutored()));
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
		lpTutored.set(FXCollections.observableList(m.getTutored()));
	}

	public void showNotAffected(ActionEvent event) {
		System.out.println(m.getTutors().size() + " " + m.getTutored().size());
		List<Tutor> tmpTutors = new ArrayList<>();
		List<Tutored> tmpTutored = new ArrayList<>();
		List<Tutored> tmp = new ArrayList<>();
		for (Tutored tutored : m.getTutored()) {
			boolean affected = false;
			for (Tutor tutor : m.getTutors()) {
				if (!tutor.hasTutored() && !tmpTutors.contains(tutor)) {
					tmpTutors.add(tutor);
				}
				affected = tutor.getTutored().contains(tutored);
				System.out.println(affected);
			}
			if (affected)
				tmp.add(tutored);
		}
		for (Tutored tutored : m.getTutored()) {
			if (!tmp.contains(tutored)) {
				tmpTutored.add(tutored);
			}
		}
		if (tmpTutors.isEmpty() && tmpTutored.isEmpty()) {
			lpTutor.set(FXCollections.observableList(m.getTutors()));
			lpTutored.set(FXCollections.observableList(m.getTutored()));
		} else {
			lpTutor.set(FXCollections.observableList(tmpTutors));
			lpTutored.set(FXCollections.observableList(tmpTutored));
		}

		System.out.println(m.getTutors().size() + " " + m.getTutored().size());
		System.out.println(tmpTutors.size() + " " + tmpTutored.size());
	}

	public void affect(ActionEvent event) {

	}

	public void setResLimit(Event event) {
		m.setLimit((int) resLimitSlider.getValue());
		resLimitLabel.setText("" + m.getLimit());
	}

	public void loadCSV(ActionEvent event) {
		FileChooser fc = new FileChooser();
		File f = fc.showOpenDialog(addTutor.getScene().getWindow());
		if(f == null) 
			return;
		List<Tutor> tutors = new ArrayList<Tutor>();
		List<Tutored> tutored = new ArrayList<Tutored>();
		for (Student stu : StudentCSVReader.read(f)) {
			if (stu.getClass().equals(Tutor.class))
				tutors.add((Tutor) stu);
			else
				tutored.add((Tutored) stu);
		}
		m.addTutor(tutors);
		m.addTutored(tutored);
		lpTutor.set(FXCollections.observableList(m.getTutors()));
		lpTutored.set(FXCollections.observableList(m.getTutored()));
	}

	public void searchStudent(KeyEvent e) {
		List<Tutor> tmpTutors = new ArrayList<>();
		List<Tutored> tmpTutored = new ArrayList<>();
		lpTutor.clear();
		lpTutored.clear();
		String parseSearch = searchStudentField.getText().equals("") ? ""
				: searchStudentField.getText().substring(0, searchStudentField.getText().length());
		for (Tutor tutor : m.getTutors()) {
			if (tutor.getLastName().equals(parseSearch)) {
				tmpTutors.add(tutor);
			}
		}
		for (Tutored t : m.getTutored()) {
			if (t.getLastName().equals(parseSearch)) {
				tmpTutored.add(t);
			}
		}
		if (parseSearch.equals("")) {
			lpTutor.set(FXCollections.observableList(m.getTutors()));
			lpTutored.set(FXCollections.observableList(m.getTutored()));
		} else {
			System.out.println(m.getTutors().size() + " " + m.getTutored().size());
			lpTutor.set(FXCollections.observableList(tmpTutors));
			lpTutored.set(FXCollections.observableList(tmpTutored));
			System.out.println(m.getTutors().size() + " " + m.getTutored().size());
		}
	}

	public void showTutored(MouseEvent e) {
		Tutor tmp = listTutor.getSelectionModel().getSelectedItem();
		lpTutored.clear();
		lpTutored.set(FXCollections.observableList(tmp.getTutored()));
	}

}
