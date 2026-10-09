
package Abstraction.assignmentproblems;

import java.util.*;

public class MovieTicketCounter {
    abstract static class Ticket {
        int count;
        static final double CONVENIENCE_FEE = 20;

        Ticket(int count) {
            this.count = count;
        }

        abstract double getPrice();

        double calculateTotal() {
            return count * (getPrice() + CONVENIENCE_FEE);
        }

        abstract String getType();
    }

    static class Regular extends Ticket {
        Regular(int count) {
            super(count);
        }

        double getPrice() {
            return 150;
        }

        String getType() {
            return "REGULAR";
        }
    }

    static class Premium extends Ticket {
        Premium(int count) {
            super(count);
        }

        double getPrice() {
            return 250;
        }

        String getType() {
            return "PREMIUM";
        }
    }

    static class Recliner extends Ticket {
        Recliner(int count) {
            super(count);
        }

        double getPrice() {
            return 400;
        }

        String getType() {
            return "RECLINER";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of bookings: ");
        int n = sc.nextInt();

        List<Ticket> tickets = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter seat type (REGULAR/PREMIUM/RECLINER): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter number of tickets: ");
            int count = sc.nextInt();

            Ticket ticket;

            switch (type) {
                case "REGULAR":
                    ticket = new Regular(count);
                    break;
                case "PREMIUM":
                    ticket = new Premium(count);
                    break;
                case "RECLINER":
                    ticket = new Recliner(count);
                    break;
                default:
                    System.out.println("Invalid seat type");
                    i--;
                    continue;
            }

            tickets.add(ticket);
        }

        for (Ticket ticket : tickets) {
            double amount = ticket.calculateTotal();
            System.out.printf("%s: %.2f%n", ticket.getType(), amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}