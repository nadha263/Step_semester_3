
package OOP_Fundamental.assignmentproblems;

import java.util.*;

public class HostelElectricityBill {
    interface Room {
        double calculate(int units, int occupants);
    }

    static class Single implements Room {
        public double calculate(int units, int occupants) {
            return units * 8;
        }
    }

    static class Shared implements Room {
        public double calculate(int units, int occupants) {
            return (units * 6.0) / occupants;
        }
    }

    static class AC implements Room {
        public double calculate(int units, int occupants) {
            return units * 10 + 200;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Room> rooms = new HashMap<>();
        rooms.put("SINGLE", new Single());
        rooms.put("SHARED", new Shared());
        rooms.put("AC", new AC());

        System.out.print("Enter number of rooms: ");
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter room type (SINGLE/SHARED/AC): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter electricity units: ");
            int units = sc.nextInt();

            int occupants = 1;

            if (type.equals("SHARED")) {
                System.out.print("Enter number of occupants: ");
                occupants = sc.nextInt();
            }

            double bill = rooms.get(type).calculate(units, occupants);

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}