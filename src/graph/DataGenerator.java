package graph;

import tutoring.Resource;
import tutoring.Student;
import tutoring.tutor.Tutor;
import tutoring.tutored.Tutored;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class in charge to generate data
 *
 * @author quentin.barlet.etu
 * @author marine.sandras.etu
 * @author simon.bocquet.etu
 * The 09 mai 2022
 */
public class DataGenerator {

    public static final Resource resource = Resource.BDD;
    public static final ArrayList<Student> tutors = generateTutorList();
    public static final ArrayList<Student> tutored = generateTutoredList();
    public static final ArrayList<Student> data = mergeArrays();

    private static ArrayList<Student> mergeArrays() {
        ArrayList<Student> list = new ArrayList<>();
        list.addAll(DataGenerator.tutors);
        list.addAll(DataGenerator.tutored);

        return list;
    }

    private static ArrayList<Student> generateTutorList() {

        // Tutors : 5 items
        ArrayList<Student> tutors = new ArrayList<>();
        Tutor A = new Tutor("A", "A", 2, resource);
        A.addGrade(resource, 16.2);
        tutors.add(A);
        Tutor B = new Tutor("B", "B", 3, resource);
        B.addGrade(resource, 15.3);
        tutors.add(B);
        Tutor C = new Tutor("C", "C", 2, resource);
        C.addGrade(resource, 15.6);
        tutors.add(C);
        Tutor D = new Tutor("D", "D", 3, resource);
        D.addGrade(resource, 18.2);
        tutors.add(D);
        Tutor E = new Tutor("E", "E", 3, resource);
        E.addGrade(resource, 14.9);
        tutors.add(E);

        return tutors;
    }

    private static ArrayList<Student> generateTutoredList() {

        // Tutored : 6 items
        ArrayList<Student> tutored = new ArrayList<>();
        Tutored L = new Tutored("L", "L", resource);
        L.addGrade(resource, 10.1);
        tutored.add(L);
        Tutored M = new Tutored("M", "M", resource);
        M.addGrade(resource, 4.7);
        tutored.add(M);
        Tutored N = new Tutored("N", "N", resource);
        N.addGrade(resource, 9.8);
        tutored.add(N);
        Tutored O = new Tutored("O", "O", resource);
        O.addGrade(resource, 8.6);
        tutored.add(O);
        Tutored P = new Tutored("P", "P", resource);
        P.addGrade(resource, 6.5);
        tutored.add(P);
        Tutored Q = new Tutored("Q", "Q", resource);
        Q.addGrade(resource, 8.9);
        tutored.add(Q);

        return tutored;
    }

    public static void fillSizeDifference() {
        if (tutors.size() < tutored.size()) {
            // rajouter en double tutor 3e année jusqu'à atteindre la taille des tutored
            List<Student> thirdStudyLevelStudents = tutors.stream().filter(new Predicate<Student>() {
                @Override
                public boolean test(Student s) {
                    return s.getStudyLevel() == 3;
                }
            }).collect(Collectors.toList());
//            System.out.println(thirdStudyLevel.size()); // 3
            int sizeDifference = tutored.size() - tutors.size();
            for (int i = 0; i < sizeDifference; ++i) {
                Student s = thirdStudyLevelStudents.get(i % thirdStudyLevelStudents.size());
                Tutor t = new Tutor(s.getFirstName() + "2", s.getLastName(), 3, Resource.BDD);
                t.addGrade(Resource.BDD, s.getAverage(Resource.BDD));
                tutors.add(t);
            }
        } else {
            // rajouter des tutored null avec des poids énormes
            for (int i = tutored.size(); i < tutors.size(); ++i) {
                Tutored s = new Tutored("null", "null");
                tutored.add(s);
            }
        }
    }
}
