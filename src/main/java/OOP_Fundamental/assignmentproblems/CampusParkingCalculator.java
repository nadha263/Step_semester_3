
package OOP_Fundamental.assignmentproblems;

import java.util.*;

public class CampusParkingCalculator {
    interface Vehicle {
        double calculate(int hours);
    }

    static class Bike implements Vehicle {
        public double calculate(int hours) {
            return hours * 10;
        }
    }

    static class Car implements Vehicle {
        public double calculate(int hours) {
            return 30 + (hours - 1) * 20;
        }
    }

    static class Truck implements Vehicle {
        public double calculate(int hours) {
            return Math.max(hours * 50, 100);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new HashMap<>();
        vehicles.put("BIKE", new Bike());
        vehicles.put("CAR", new Car());
        vehicles.put("TRUCK", new Truck());

        System.out.print("Enter number of parked vehicles: ");
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter vehicle type (BIKE/CAR/TRUCK): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter parking hours: ");
            int hours = sc.nextInt();

            double charge = vehicles.get(type).calculate(hours);

            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}