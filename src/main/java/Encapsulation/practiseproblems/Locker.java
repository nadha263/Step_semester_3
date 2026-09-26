package Encapsulation.practiseproblems;


import java.util.Scanner;

public class Locker {

    private String code;
    private final int lockerNumber;

    
    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    
    void changeCode(String currentCode, String newCode) {

        if (code.equals(currentCode)) {
            code = newCode;
            System.out.println("Code changed successfully.");
        } else {
            System.out.println("Wrong current code. Change rejected.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter locker number: ");
        int number = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter initial code: ");
        String code = sc.nextLine();

        Locker l = new Locker(number, code);

        System.out.print("Enter current code: ");
        String currentCode = sc.nextLine();

        System.out.print("Enter new code: ");
        String newCode = sc.nextLine();

        l.changeCode(currentCode, newCode);

        sc.close();
    }
}
