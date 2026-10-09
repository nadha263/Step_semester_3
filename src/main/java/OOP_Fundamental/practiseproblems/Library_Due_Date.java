
package OOP_Fundamental.practiseproblems;

import java.util.*;
import java.time.*;

public class Library_Due_Date {
    interface LibraryItem {
        LocalDate getDueDate();
    }

    static class Book implements LibraryItem {
        public LocalDate getDueDate() {
            return LocalDate.of(2023, 10, 26).plusDays(14);
        }
    }

    static class DVD implements LibraryItem {
        public LocalDate getDueDate() {
            return LocalDate.of(2023, 10, 26).plusDays(7);
        }
    }

    static class Magazine implements LibraryItem {
        public LocalDate getDueDate() {
            return LocalDate.of(2023, 10, 26).plusDays(3);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, LibraryItem> items = new HashMap<>();
        items.put("BOOK", new Book());
        items.put("DVD", new DVD());
        items.put("MAGAZINE", new Magazine());

        System.out.print("Enter number of borrowed items: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Enter item type (BOOK/DVD/MAGAZINE): ");
            String type = sc.nextLine().trim().toUpperCase();

            System.out.print("Enter item title: ");
            String title = sc.nextLine();

            LibraryItem item = items.get(type);

            System.out.println(title + ": " + item.getDueDate());
        }

        sc.close();
    }
}