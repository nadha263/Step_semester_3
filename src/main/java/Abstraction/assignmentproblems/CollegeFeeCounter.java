
package Abstraction.assignmentproblems;

import java.util.*;

public class CollegeFeeCounter {
    abstract static class Student {
        String name;
        static final double TRANSPORT_FEE = 12000;

        Student(String name) {
            this.name = name;
        }

        abstract double calculateTuition();

        abstract boolean usesBus();

        double calculateTotalFee() {
            return calculateTuition() + (usesBus() ? TRANSPORT_FEE : 0);
        }
    }

    static class DayScholar extends Student {
        DayScholar(String name) {
            super(name);
        }

        double calculateTuition() {
            return 40000;
        }

        boolean usesBus() {
            return true;
        }
    }

    static class Hosteller extends Student {
        Hosteller(String name) {
            super(name);
        }

        double calculateTuition() {
            return 40000 + 60000;
        }

        boolean usesBus() {
            return false;
        }
    }

    static class Scholar extends Student {
        Scholar(String name) {
            super(name);
        }

        double calculateTuition() {
            return 20000;
        }

        boolean usesBus() {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        List<Student> students = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student type (DAY_SCHOLAR/HOSTELLER/SCHOLAR): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter student name: ");
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    student = new Scholar(name);
                    break;
                default:
                    System.out.println("Invalid student type");
                    i--;
                    continue;
            }

            students.add(student);
        }

        for (Student student : students) {
            double fee = student.calculateTotalFee();
            System.out.printf("%s: %.2f%n", student.name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}