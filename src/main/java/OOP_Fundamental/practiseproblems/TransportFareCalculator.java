
package OOP_Fundamental.practiseproblems;

import java.util.*;

public class TransportFareCalculator {
    interface Transport {
        double calculate(double distance, double peakHourFactor);
    }

    static class Bus implements Transport {
        public double calculate(double distance, double peakHourFactor) {
            return Math.min(2 + 0.10 * distance, 10);
        }
    }

    static class Train implements Transport {
        public double calculate(double distance, double peakHourFactor) {
            return 3 + 0.15 * distance;
        }
    }

    static class Metro implements Transport {
        public double calculate(double distance, double peakHourFactor) {
            return (1.50 + 0.20 * distance) * peakHourFactor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Transport> transports = new HashMap<>();
        transports.put("BUS", new Bus());
        transports.put("TRAIN", new Train());
        transports.put("METRO", new Metro());

        System.out.print("Enter number of journeys: ");
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter transport type (BUS/TRAIN/METRO): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter distance in km: ");
            double distance = sc.nextDouble();

            double factor = 1.0;

            if (type.equals("METRO")) {
                System.out.print("Enter peak hour factor (1.0 to 2.0): ");
                factor = sc.nextDouble();
            }

            Transport transport = transports.get(type);
            double fare = transport.calculate(distance, factor);

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}