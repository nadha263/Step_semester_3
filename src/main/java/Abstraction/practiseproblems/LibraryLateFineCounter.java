
package Abstraction.practiseproblems;

import java.util.*;

public class LibraryLateFineCounter {
    abstract static class LibraryItem {
        String title;
        int daysLate;

        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        abstract double calculateFine();
    }

    static class Book extends LibraryItem {
        Book(String title, int daysLate) {
            super(title, daysLate);
        }

        double calculateFine() {
            return daysLate * 2.0;
        }
    }

    static class DVD extends LibraryItem {
        DVD(String title, int daysLate) {
            super(title, daysLate);
        }

        double calculateFine() {
            return Math.min(daysLate * 5.0, 50);
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title, int daysLate) {
            super(title, daysLate);
        }

        double calculateFine() {
            return daysLate;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of library items: ");
        int n = sc.nextInt();

        List<LibraryItem> items = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter item type (BOOK/DVD/MAGAZINE): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter item title: ");
            String title = sc.next();

            System.out.print("Enter days late: ");
            int days = sc.nextInt();

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(title, days);
                    break;

                case "DVD":
                    item = new DVD(title, days);
                    break;

                case "MAGAZINE":
                    item = new Magazine(title, days);
                    break;

                default:
                    System.out.println("Invalid item type");
                    i--;
                    continue;
            }

            items.add(item);
        }

        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            System.out.printf("%s: %.2f%n", item.title, fine);
            total += fine;
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}