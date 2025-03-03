import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " - Marks: " + marks;
    }
}

public class StudentFiltering {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 78));
        students.add(new Student("Emma", 90));
        students.add(new Student("Liam", 65));
        students.add(new Student("Olivia", 82));

        // Filtering students scoring above 75% and sorting them by marks
        List<Student> filteredStudents = students.stream()
                .filter(s -> s.marks > 75)
                .sorted((s1, s2) -> Double.compare(s2.marks, s1.marks)) // Sorting in descending order
                .collect(Collectors.toList());

        // Displaying student names
        filteredStudents.forEach(System.out::println);
    }
}
