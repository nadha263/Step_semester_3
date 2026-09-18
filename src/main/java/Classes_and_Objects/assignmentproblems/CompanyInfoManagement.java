package Classes_and_Objects.assignmentproblems;

import java.util.Scanner;

class Emp {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Emp(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class CompanyInfoManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee 1 name: ");
        String name1 = sc.nextLine();

        System.out.print("Enter employee 1 salary: ");
        double salary1 = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter employee 2 name: ");
        String name2 = sc.nextLine();

        System.out.print("Enter employee 2 salary: ");
        double salary2 = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter employee 3 name: ");
        String name3 = sc.nextLine();

        System.out.print("Enter employee 3 salary: ");
        double salary3 = sc.nextDouble();

        Emp e1 = new Emp(name1, salary1);
        Emp e2 = new Emp(name2, salary2);
        Emp e3 = new Emp(name3, salary3);

        Emp.printCompanyInfo();

        sc.close();
    }
}