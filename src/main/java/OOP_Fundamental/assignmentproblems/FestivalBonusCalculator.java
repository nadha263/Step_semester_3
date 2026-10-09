
package OOP_Fundamental.assignmentproblems;

import java.util.*;

public class FestivalBonusCalculator {
    interface Employee {
        double calculateBonus(double salary);
    }

    static class FullTime implements Employee {
        public double calculateBonus(double salary) {
            return salary * 0.10;
        }
    }

    static class PartTime implements Employee {
        public double calculateBonus(double salary) {
            return salary * 0.05;
        }
    }

    static class Intern implements Employee {
        public double calculateBonus(double salary) {
            return 2000;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Employee> employees = new HashMap<>();
        employees.put("FULLTIME", new FullTime());
        employees.put("PARTTIME", new PartTime());
        employees.put("INTERN", new Intern());

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter employee type (FULLTIME/PARTTIME/INTERN): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter employee name: ");
            String name = sc.next();

            System.out.print("Enter monthly salary: ");
            double salary = sc.nextDouble();

            double bonus = employees.get(type).calculateBonus(salary);

            System.out.printf("%s: %.2f%n", name, bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}