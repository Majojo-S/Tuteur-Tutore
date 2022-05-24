package reader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import exception.FileFormatException;
import tutoring.Resource;
import tutoring.Student;

public class StudentCSVReader {
	ArrayList<Student> stu;
	
	public StudentCSVReader() {
		stu = new ArrayList<>();
	}
	
	public void read(File f) {
		try (BufferedReader br = new BufferedReader(new FileReader(f))){
			String line;
			Student tmp = null;
			while((line = br.readLine()) != null) {
				String[] splitted = line.split(",");
				if(splitted.length < 3 || (splitted.length-3)%2!=0) {
					throw new FileFormatException();
				}
				String firstName = splitted[0];
				String lastName = splitted[1];
				int studentLvl = Integer.parseInt(splitted[2]);
				tmp = new Student(firstName, lastName, studentLvl);
				for(int i = 3 ; i<splitted.length-1 ; i+=2) {
					Resource r = Resource.valueOf(splitted[i]);
					double g = Double.parseDouble(splitted[i+1]);
					tmp.addGrade(r, g);
				}
			}
			//Name;Name;Lvl;Res;note
			stu.add(tmp);
		} catch (FileNotFoundException e) {
			System.out.println("File not Found !");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FileFormatException e) {
			System.out.println("File Format not good !");
			System.exit(1);
		}
	}
	
	public ArrayList<Student> getListStudent() {
		return stu;
	}
}
