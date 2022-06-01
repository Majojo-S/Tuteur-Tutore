package ui.model;

import java.util.ArrayList;
import java.util.List;

import tutoring.Resource;
import tutoring.Student;
import tutoring.tutor.Tutor;
import tutoring.tutored.Tutored;

public class Model {
	private List<Tutor> tutors;
	private List<Tutored> tutored;
	private Resource resource;
	
	public Model() {
		tutors = new ArrayList<>();
		tutored = new ArrayList<>();
		resource = Resource.ALGO;
	}
	
	public Tutor addTutor(String firstName, String lastName) {
		Tutor res = new Tutor(firstName, lastName);
		tutors.add(res);
		return res;
	}
	
	public void removeTutor(String firstName, String lastName) {
		tutors.remove(new Tutor(firstName, lastName));
	}
	
	public void removeTutor(Student student) {
		tutors.remove(student);
	}
	
	public void addTutored(String firstName, String lastName) {
		tutored.add(new Tutored(firstName, lastName));
	}
	
	public void removeTutored(String firstName, String lastName) {
		tutored.remove(new Tutored(firstName, lastName));
	}
	
	public void removeTutored(Student student) {
		tutored.remove(student);
	}
	
	public void ajustResLimit(int limit) {
		if(limit > 0) {
			resource.setLimit(limit);
		}
	}
	
	public Student searchStudent(String firstName, String lastName) {
		Student search = new Student(firstName, lastName);
		if(tutors.contains(search))
			return (Tutor) search;
		if(tutored.contains(search))
			return (Tutored) search;
		return null;
	}

	public List<Tutor> getTutors() {
		return tutors;
	}

	public List<Tutored> getTutored() {
		return tutored;
	}
	
	public int getLimit() {
		return resource.getLimit();
	}
	
	public void setLimit(int limit) {
		resource.setLimit(limit);
	}

	public void addTutor(List<Tutor> tutors) {
		this.tutors.addAll(tutors);
	}
	
	public void addTutored(List<Tutored> tutored) {
		this.tutored.addAll(tutored);
	}
}
