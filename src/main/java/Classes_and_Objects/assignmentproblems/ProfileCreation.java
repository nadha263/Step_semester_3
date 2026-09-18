package Classes_and_Objects.assignmentproblems;

import java.util.Scanner;

class Employee {

    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Constructor for permanent employee
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for intern
    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    // Print profile
    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs "
                + salary + " | Intern: " + isIntern);
    }
}

public class ProfileCreation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter permanent employee ID: ");
        String id1 = sc.nextLine();

        System.out.print("Enter permanent employee name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        Employee e1 = new Employee(id1, name1, salary);

        System.out.print("Enter intern employee ID: ");
        String id2 = sc.nextLine();

        System.out.print("Enter intern employee name: ");
        String name2 = sc.nextLine();

        Employee e2 = new Employee(id2, name2);

        e1.printProfile();
        e2.printProfile();

        sc.close();
    }
}