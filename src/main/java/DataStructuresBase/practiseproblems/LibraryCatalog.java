  
package DataStructuresBase.practiseproblems;

import java.util.Scanner;

public class LibraryCatalog {

    static String findBook(String[][] catalog, String targetIsbn) {

        int low = 0;
        int high = catalog.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = catalog[mid][0].compareTo(targetIsbn);

            if (result == 0) {
                return catalog[mid][1];
            } 
            else if (result < 0) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();

        String[][] catalog = new String[n][2];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter ISBN: ");
            catalog[i][0] = sc.next();

            System.out.print("Enter title: ");
            catalog[i][1] = sc.next();
        }

        System.out.print("Enter target ISBN: ");
        String target = sc.next();

        System.out.println(findBook(catalog, target));

        sc.close();
    }
}
