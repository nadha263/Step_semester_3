
package DSA.practiseproblems;

import java.util.Scanner;

interface PaymentMode {

    double processPayment(double amount);

    double getFee(double amount);

    String getMode();
}

class CashPayment implements PaymentMode {

    public double processPayment(double amount) {
        return amount;
    }

    public double getFee(double amount) {
        return 0;
    }

    public String getMode() {
        return "Cash";
    }
}

class CardPayment implements PaymentMode {

    public double processPayment(double amount) {
        return amount + amount * 0.02;
    }

    public double getFee(double amount) {
        return amount * 0.02;
    }

    public String getMode() {
        return "Card";
    }
}

class UpiPayment implements PaymentMode {

    public double processPayment(double amount) {
        return amount;
    }

    public double getFee(double amount) {
        return 0;
    }

    public String getMode() {
        return "UPI";
    }
}

public class PaymentProcessing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of payments: ");
        int n = sc.nextInt();

        PaymentMode[] payments = new PaymentMode[n];

        double[] amounts = new double[n];

        for (int i = 0; i < n; i++) {

            String mode = sc.next();
            double amount = sc.nextDouble();

            amounts[i] = amount;

            if (mode.equalsIgnoreCase("Cash")) {
                payments[i] = new CashPayment();
            }
            else if (mode.equalsIgnoreCase("Card")) {
                payments[i] = new CardPayment();
            }
            else {
                payments[i] = new UpiPayment();
            }
        }

        double total = 0;

        for (int i = 0; i < n; i++) {

            double amount = amounts[i];

            double fee = payments[i].getFee(amount);

            double processed = payments[i].processPayment(amount);

            System.out.printf("%s: amount %.1f, fee %.1f, processed %.1f%n",
                    payments[i].getMode(), amount, fee, processed);

            total += processed;
        }

        System.out.printf("Total Amount Processed: %.1f%n", total);

        sc.close();
    }
}
