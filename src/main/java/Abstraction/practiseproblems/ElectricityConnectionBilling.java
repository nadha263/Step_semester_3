
package Abstraction.practiseproblems;

import java.util.*;

public class ElectricityConnectionBilling {
    abstract static class Connection {
        int units;

        Connection(int units) {
            this.units = units;
        }

        abstract double calculateBill();

        abstract String getType();
    }

    static class Home extends Connection {
        Home(int units) {
            super(units);
        }

        double calculateBill() {
            if (units <= 100) {
                return units * 5.0;
            }
            return 100 * 5.0 + (units - 100) * 7.0;
        }

        String getType() {
            return "HOME";
        }
    }

    static class Shop extends Connection {
        Shop(int units) {
            super(units);
        }

        double calculateBill() {
            return units * 8.0 + 100;
        }

        String getType() {
            return "SHOP";
        }
    }

    static class Factory extends Connection {
        Factory(int units) {
            super(units);
        }

        double calculateBill() {
            return Math.max(units * 6.0, 1000);
        }

        String getType() {
            return "FACTORY";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of connections: ");
        int n = sc.nextInt();

        List<Connection> connections = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter connection type (HOME/SHOP/FACTORY): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter units consumed: ");
            int units = sc.nextInt();

            Connection connection;

            switch (type) {
                case "HOME":
                    connection = new Home(units);
                    break;

                case "SHOP":
                    connection = new Shop(units);
                    break;

                case "FACTORY":
                    connection = new Factory(units);
                    break;

                default:
                    System.out.println("Invalid connection type");
                    i--;
                    continue;
            }

            connections.add(connection);
        }

        for (Connection connection : connections) {
            double bill = connection.calculateBill();
            System.out.printf("%s: %.2f%n", connection.getType(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}