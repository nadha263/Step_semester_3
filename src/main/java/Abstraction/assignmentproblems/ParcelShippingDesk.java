
package Abstraction.assignmentproblems;

import java.util.*;

public class ParcelShippingDesk {
    interface Insurable {
        double calculateInsurance();
    }

    abstract static class Parcel {
        double weight, declaredValue;

        Parcel(double weight, double declaredValue) {
            this.weight = weight;
            this.declaredValue = declaredValue;
        }

        abstract double calculateCharge();

        double calculateInsurance() {
            return 0;
        }

        double calculateTotal() {
            return calculateCharge() + calculateInsurance();
        }

        abstract String getType();
    }

    static class Standard extends Parcel {
        Standard(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        double calculateCharge() {
            return 40 + 10 * weight;
        }

        String getType() {
            return "STANDARD";
        }
    }

    static class Express extends Parcel implements Insurable {
        Express(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        double calculateCharge() {
            return 80 + 15 * weight;
        }

        public double calculateInsurance() {
            return declaredValue * 0.02;
        }

        String getType() {
            return "EXPRESS";
        }
    }

    static class Fragile extends Parcel implements Insurable {
        Fragile(double weight, double declaredValue) {
            super(weight, declaredValue);
        }

        double calculateCharge() {
            return 40 + 10 * weight + 50;
        }

        public double calculateInsurance() {
            return declaredValue * 0.02;
        }

        String getType() {
            return "FRAGILE";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of parcels: ");
        int n = sc.nextInt();

        List<Parcel> parcels = new ArrayList<>();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter parcel type (STANDARD/EXPRESS/FRAGILE): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter weight in kg: ");
            double weight = sc.nextDouble();

            System.out.print("Enter declared value: ");
            double value = sc.nextDouble();

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new Standard(weight, value);
                    break;
                case "EXPRESS":
                    parcel = new Express(weight, value);
                    break;
                case "FRAGILE":
                    parcel = new Fragile(weight, value);
                    break;
                default:
                    System.out.println("Invalid parcel type");
                    i--;
                    continue;
            }

            parcels.add(parcel);
        }

        for (Parcel parcel : parcels) {
            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = parcel.calculateTotal();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                parcel.getType(), charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}