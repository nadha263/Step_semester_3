
package Abstraction.assignmentproblems;

import java.util.*;

public class CityCabFareMeter {
    interface NightService {
        double calculateNightFare(double fare);
    }

    abstract static class Cab {
        double distance;

        Cab(double distance) {
            this.distance = distance;
        }

        abstract double getRate();

        abstract String getType();

        double calculateFare() {
            return Math.max(distance * getRate(), 100);
        }
    }

    static class Mini extends Cab {
        Mini(double distance) {
            super(distance);
        }

        double getRate() {
            return 10;
        }

        String getType() {
            return "MINI";
        }
    }

    static class Sedan extends Cab implements NightService {
        Sedan(double distance) {
            super(distance);
        }

        double getRate() {
            return 14;
        }

        public double calculateNightFare(double fare) {
            return fare * 1.20;
        }

        String getType() {
            return "SEDAN";
        }
    }

    static class SUV extends Cab implements NightService {
        SUV(double distance) {
            super(distance);
        }

        double getRate() {
            return 18;
        }

        public double calculateNightFare(double fare) {
            return fare * 1.20;
        }

        String getType() {
            return "SUV";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of trips: ");
        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter cab type (MINI/SEDAN/SUV): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter distance in km: ");
            double distance = sc.nextDouble();

            System.out.print("Enter trip time (DAY/NIGHT): ");
            String time = sc.next().toUpperCase();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new Mini(distance);
                    break;
                case "SEDAN":
                    cab = new Sedan(distance);
                    break;
                case "SUV":
                    cab = new SUV(distance);
                    break;
                default:
                    System.out.println("Invalid cab type");
                    i--;
                    continue;
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(cab.getType() + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                fare = ((NightService) cab).calculateNightFare(fare);
            }

            System.out.printf("%s: %.2f%n", cab.getType(), fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}