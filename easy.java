import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " - Age: " + age + ", Salary: " + salary;
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 25, 60000));
        employees.add(new Employee("Charlie", 28, 55000));

        // Sorting by salary using lambda expression
        employees.sort(Comparator.comparingDouble(emp -> emp.salary));

        // Printing sorted employees
        employees.forEach(System.out::println);
    }
}
