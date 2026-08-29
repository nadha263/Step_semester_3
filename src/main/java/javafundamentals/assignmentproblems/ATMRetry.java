package javafundamentals.assignmentproblems;

import java.util.*;

public class ATMRetry {

    static void atmPinRetry(String correctPin, String[] attempts) {

        int count = 0;
        boolean success = false;

        while (count < attempts.length && count < 3 && !success) {

            if (attempts[count].equals(correctPin)) {
                success = true;
                System.out.println("PIN accepted");
                break;
            }

            count++;
        }

        if (!success)
            System.out.println("Card blocked — too many incorrect attempts");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter correct PIN: ");
        String correctPin = sc.nextLine();

        System.out.print("Enter number of attempts: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] attempts = new String[n];

        System.out.println("Enter attempted PINs:");

        for (int i = 0; i < n; i++)
            attempts[i] = sc.nextLine();

        atmPinRetry(correctPin, attempts);

        sc.close();
    }
}