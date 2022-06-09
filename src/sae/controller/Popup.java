package sae.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import sae.tutoring.Student;

public class Popup {
	@FXML
	private TextField studentFirstNameField;
	@FXML
	private TextField studentLastNameField;
	@FXML
	private Button addButton;
	private String firstName;
	private String lastName;
	FXMLLoader loader;

	
	
	public void display(Window parent, String title) {
		File f = new File("res"+ File.separator +"AddStudent.fxml");
		try {
			loader = new FXMLLoader(f.toURI().toURL());
			Parent popup = loader.load();
			Scene scene = new Scene(popup);
			Stage stage = new Stage();
			stage.setTitle(title);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(parent);
			stage.setScene(scene);
			stage.showAndWait();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getFirstName() {
		System.out.println(firstName);
		return firstName;
	}
	
	public String getLastName() {
		System.out.println(lastName);
		return lastName;
	}
	
	public Student getStudent() {
		return new Student(studentFirstNameField.getText(), studentLastNameField.getText());
	}
	
	public void addStudent() {
		firstName = studentFirstNameField.getText();
		lastName = studentLastNameField.getText();
		((Stage) addButton.getScene().getWindow()).close();
	}
	
}
