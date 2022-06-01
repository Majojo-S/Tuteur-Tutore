package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import exception.FileFormatException;
import exception.InvalidNameException;
import exception.StudentLevelException;
import tutoring.Resource;
import tutoring.Student;
import tutoring.tutor.Tutor;
import tutoring.tutored.Tutored;

/**
 * Reads a CSV File and parses it to add a list of Student
 * 
 * @author simon.bocquet.etu
 *
 */
public class StudentCSVReader {

	/**
	 * Gives an list of students from a csv which respects the format :
	 * FirstName;LastName;StudentLvl;Resource;Grade with multiple resources and
	 * grades
	 * 
	 * @param file CSV file to be read
	 */
	public static ArrayList<Student> read(File file) {
		ArrayList<Student> stu = new ArrayList<>();
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			Student tmp = null;
			while ((line = br.readLine()) != null) {
				String[] splitted = line.split(";");
				if (splitted.length < 3 || (splitted.length - 3) % 2 != 0) {
					throw new FileFormatException();
				}
				String firstName = splitted[0].trim();
				String lastName = splitted[1].trim();
				if (firstName.isEmpty() || lastName.isEmpty())
					throw new InvalidNameException();
				int studentLvl = Integer.parseInt(splitted[2]);
				if (studentLvl <= 0 || studentLvl > 3)
					throw new StudentLevelException();
				if (studentLvl > 1)
					tmp = new Tutor(firstName, lastName, studentLvl);
				else
					tmp = new Tutored(firstName, lastName);
				for (int i = 3; i < splitted.length - 1; i += 2) {
					Resource r = Resource.valueOf(splitted[i].toUpperCase());
					double g = Double.parseDouble(splitted[i + 1]);
					tmp.addGrade(r, g);
				}
				stu.add(tmp);
			}
		} catch (StudentLevelException e) {
			System.out.println("Invalid student level !");
			System.out.println(line);
			System.exit(1);
		} catch (FileNotFoundException e) {
			System.out.println("File not Found !");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FileFormatException e) {
			System.out.println("File Format not good !");
			System.exit(1);
		} catch (NumberFormatException e) {
			System.out.println("Not A grade");
			System.exit(1);
		} catch (IllegalArgumentException e) {
			System.out.println("Resource does not exist !");
			System.exit(1);
		} catch (NullPointerException e) {
			System.out.println("Parameter is null !");
			System.exit(1);
		} catch (InvalidNameException e) {
			System.out.println("Invalid Name !");
			System.exit(1);
		} finally {
			for (Student student : stu) {
				System.out.println(student);
			}
			return stu;
		}
	}

}
