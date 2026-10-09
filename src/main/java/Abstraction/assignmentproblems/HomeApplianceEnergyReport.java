
package Abstraction.assignmentproblems;

import java.util.*;

public class HomeApplianceEnergyReport {
    interface SaverMode {
        double applySaver(double units);
    }

    abstract static class Appliance {
        double hours;
        static final double COST_PER_UNIT = 8;

        Appliance(double hours) {
            this.hours = hours;
        }

        abstract double getPower();

        abstract String getType();

        double calculateUnits() {
            return getPower() * hours / 1000;
        }

        double calculateCost(double units) {
            return units * COST_PER_UNIT;
        }
    }

    static class Fridge extends Appliance {
        Fridge(double hours) {
            super(hours);
        }

        double getPower() {
            return 150;
        }

        String getType() {
            return "FRIDGE";
        }
    }

    static class AC extends Appliance implements SaverMode {
        AC(double hours) {
            super(hours);
        }

        double getPower() {
            return 1500;
        }

        public double applySaver(double units) {
            return units * 0.75;
        }

        String getType() {
            return "AC";
        }
    }

    static class TV extends Appliance {
        TV(double hours) {
            super(hours);
        }

        double getPower() {
            return 100;
        }

        String getType() {
            return "TV";
        }
    }

    static class Washer extends Appliance implements SaverMode {
        Washer(double hours) {
            super(hours);
        }

        double getPower() {
            return 500;
        }

        public double applySaver(double units) {
            return units * 0.75;
        }

        String getType() {
            return "WASHER";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of appliances: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter appliance, hours, and optional SAVER: ");
            String[] data = sc.nextLine().trim().split("\\s+");

            String type = data[0].toUpperCase();
            double hours = Double.parseDouble(data[1]);
            boolean saver = data.length > 2 &&
                    data[2].equalsIgnoreCase("SAVER");

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;
                case "AC":
                    appliance = new AC(hours);
                    break;
                case "TV":
                    appliance = new TV(hours);
                    break;
                case "WASHER":
                    appliance = new Washer(hours);
                    break;
                default:
                    System.out.println("Invalid appliance type");
                    i--;
                    continue;
            }

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits();

            if (saver) {
                units = ((SaverMode) appliance).applySaver(units);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                    appliance.getType(), units, cost);

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}