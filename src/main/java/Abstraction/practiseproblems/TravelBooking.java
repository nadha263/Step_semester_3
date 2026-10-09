
package Abstraction.practiseproblems;

import java.util.*;

public class TravelBooking {
    abstract static class Booking {
        double distance;
        static final double BOOKING_FEE = 50;

        Booking(double distance) {
            this.distance = distance;
        }

        abstract double calculateFare();

        double calculateTotal() {
            return calculateFare() + BOOKING_FEE;
        }

        abstract String getMode();
    }

    static class Bus extends Booking {
        Bus(double distance) {
            super(distance);
        }

        double calculateFare() {
            return distance * 2;
        }

        String getMode() {
            return "BUS";
        }
    }

    static class Train extends Booking {
        Train(double distance) {
            super(distance);
        }

        double calculateFare() {
            return distance * 1.5;
        }

        String getMode() {
            return "TRAIN";
        }
    }

    static class Flight extends Booking {
        Flight(double distance) {
            super(distance);
        }

        double calculateFare() {
            return 2500 + distance * 4;
        }

        String getMode() {
            return "FLIGHT";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bookings: ");
        int n = sc.nextInt();

        List<Booking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter travel mode (BUS/TRAIN/FLIGHT): ");
            String mode = sc.next().toUpperCase();

            System.out.print("Enter distance in km: ");
            double distance = sc.nextDouble();

            Booking booking;

            switch (mode) {
                case "BUS":
                    booking = new Bus(distance);
                    break;

                case "TRAIN":
                    booking = new Train(distance);
                    break;

                case "FLIGHT":
                    booking = new Flight(distance);
                    break;

                default:
                    System.out.println("Invalid travel mode");
                    i--;
                    continue;
            }

            bookings.add(booking);
        }

        for (Booking booking : bookings) {
            System.out.printf("%s: %.2f%n",
                    booking.getMode(), booking.calculateTotal());
        }

        sc.close();
    }
}