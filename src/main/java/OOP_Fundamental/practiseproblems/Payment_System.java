
package OOP_Fundamental.practiseproblems;

import java.util.*;

public class Payment_System {
    interface Payment {
        double calculate(double amount);
    }

    static class Card implements Payment {
        public double calculate(double amount) {
            return amount * 1.02;
        }
    }

    static class Wallet implements Payment {
        public double calculate(double amount) {
            return amount * 1.01;
        }
    }

    static class BankTransfer implements Payment {
        public double calculate(double amount) {
            return amount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Payment> payments = new HashMap<>();
        payments.put("CARD", new Card());
        payments.put("WALLET", new Wallet());
        payments.put("BANKTRANSFER", new BankTransfer());

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter payment type (CARD/WALLET/BANKTRANSFER): ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter transaction amount: ");
            double amount = sc.nextDouble();

            double adjusted = payments.get(type).calculate(amount);

            System.out.printf("%s: %.2f%n", type, adjusted);
            total += adjusted;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}