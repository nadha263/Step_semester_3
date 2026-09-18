package Classes_and_Objects.assignmentproblems;

import java.util.Scanner;

class HallTicket {
    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class HallTicketManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

       
        HallTicket priya = new HallTicket(name, 0);

        
        HallTicket copy = priya;

        
        System.out.print("Enter new seat number: ");
        int seat = sc.nextInt();

        copy.seatNumber = seat;

        
        HallTicket separate = new HallTicket(name, seat);

        System.out.println(name + "'s seatNumber :");
        System.out.println(priya.seatNumber);

        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));

        sc.close();
    }
}