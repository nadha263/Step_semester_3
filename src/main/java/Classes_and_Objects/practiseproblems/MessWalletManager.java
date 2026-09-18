package Classes_and_Objects.practiseproblems;

import java.util.Scanner;

class MessWallet {
    private double balance;

    public MessWallet(double balance) {
        if (balance < 0) {
            System.out.println("Warning: Negative balance");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0)
            System.out.println("Top-up rejected");
        else {
            balance += amount;
            System.out.println("Balance after top-up: " + balance);
        }
    }

    public void deduct(double amount) {
        if (amount > balance)
            System.out.println("Deduct rejected: insufficient balance");
        else {
            balance -= amount;
            System.out.println("Balance after deduction: " + balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class MessWalletManager{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Opening balance: ");
        double b = sc.nextDouble();

        MessWallet w = new MessWallet(b);

        System.out.print("Top-up: ");
        w.topUp(sc.nextDouble());

        System.out.print("Deduct: ");
        w.deduct(sc.nextDouble());

        System.out.println("Final balance: " + w.getBalance());

        sc.close();
    }
}
