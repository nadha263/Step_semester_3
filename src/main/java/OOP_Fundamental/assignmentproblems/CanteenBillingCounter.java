
package OOP_Fundamental.assignmentproblems;

import java.util.*;

public class CanteenBillingCounter {
    interface Customer {
        double calculate(double amount);
    }

    static class Student implements Customer {
        public double calculate(double amount) {
            return amount * 0.90;
        }
    }

    static class Staff implements Customer {
        public double calculate(double amount) {
            return amount * 0.95;
        }
    }

    static class Guest implements Customer {
        public double calculate(double amount) {
            return amount + 10;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Customer> customers = new HashMap<>();
        customers.put("STUDENT", new Student());
        customers.put("STAFF", new Staff());
        customers.put("GUEST", new Guest());

        System.out.print("Enter number of bills: ");
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter customer type (STUDENT/STAFF/GUEST): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter bill amount: ");
            double amount = sc.nextDouble();

            double finalAmount = customers.get(type).calculate(amount);

            System.out.printf("%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}