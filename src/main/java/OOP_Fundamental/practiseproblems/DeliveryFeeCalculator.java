
package OOP_Fundamental.practiseproblems;

import java.util.*;

public class DeliveryFeeCalculator {
    interface Delivery {
        double calculate(double weight, double distance, double customsFee);
    }

    static class Standard implements Delivery {
        public double calculate(double weight, double distance, double customsFee) {
            return 5 + 0.50 * weight + 0.10 * distance;
        }
    }

    static class Express implements Delivery {
        public double calculate(double weight, double distance, double customsFee) {
            return 15 + weight + 0.20 * distance;
        }
    }

    static class International implements Delivery {
        public double calculate(double weight, double distance, double customsFee) {
            return 25 + 2 * weight + 0.50 * distance + customsFee;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Delivery> deliveries = new HashMap<>();
        deliveries.put("STANDARD", new Standard());
        deliveries.put("EXPRESS", new Express());
        deliveries.put("INTERNATIONAL", new International());

        System.out.print("Enter number of delivery requests: ");
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter delivery type (STANDARD/EXPRESS/INTERNATIONAL): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter weight in kg: ");
            double weight = sc.nextDouble();

            System.out.print("Enter distance in km: ");
            double distance = sc.nextDouble();

            double customsFee = 0;

            if (type.equals("INTERNATIONAL")) {
                System.out.print("Enter customs fee: ");
                customsFee = sc.nextDouble();
            }

            Delivery delivery = deliveries.get(type);
            double fee = delivery.calculate(weight, distance, customsFee);

            System.out.printf("%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}