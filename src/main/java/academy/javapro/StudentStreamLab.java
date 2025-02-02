package academy.javapro;

import java.util.*;
import java.util.stream.*;

public class StudentStreamLab {
    public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = Arrays.asList(
                new Student("Alice", 3.5, "Junior"),
                new Student("Bob", 3.8, "Senior"),
                new Student("Charlie", 2.9, "Sophomore"),
                new Student("David", 3.1, "Freshman"),
                new Student("Eve", 3.9, "Junior")
        );

        // TODO - Filtering: Students with GPA > 3.0

        System.out.println("Students with GPA > 3.0:");
        students.stream()
                .filter(s -> s.getGpa() > 3.0)
                .forEach(System.out::println);

        // TODO - Mapping: Extract names of students with GPA > 3.0
 
        String highGpaNames = students.stream()
                .filter(s -> s.getGpa() > 3.0)
                .map(Student::getName)
                .collect(Collectors.joining(", "));

                System.out.println("\nHigh GPA student names: " + highGpaNames);


        // TODO - Reducing: Calculate the average GPA of all students

        double averageGpa = students.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);

        System.out.printf("\nAverage GPA: %.2f\n", averageGpa);
        
        // TODO Collecting: Collect all "Junior" students into a list

        List<Student> juniorStudents = students.stream()
                .filter(s -> s.getCollegeYear().equals("Junior"))
                .collect(Collectors.toList());

        System.out.println("\nJuniors:");
        juniorStudents.forEach(System.out::println);
    }
}
