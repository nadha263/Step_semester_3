
package DSA.practiseproblems;

import java.util.Scanner;

public class LibraryReturnDesk {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] stack = new String[3];
        String[] queue = new String[3];

        int top = -1;

        int front = 0;
        int rear = 0;
        int size = 0;

        System.out.print("Enter number of commands: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String command = sc.next().replace(",", "");

            if (command.equals("RETURN")) {

                String book = sc.next().replace(",", "");

                if (top == 2) {
                    System.out.println(book + " rejected: pile is full");
                } else {
                    top++;
                    stack[top] = book;

                    System.out.println(book + " placed on pile");
                }
            }

            else if (command.equals("SHELVE")) {

                if (top == -1) {
                    System.out.println("pile is empty");
                } else {
                    System.out.println("shelved " + stack[top]);
                    top--;
                }
            }

            else if (command.equals("WAIT")) {

                String name = sc.next().replace(",", "");

                if (size == 3) {
                    System.out.println(name + " rejected: line is full");
                } else {
                    queue[rear] = name;
                    rear = (rear + 1) % 3;
                    size++;

                    System.out.println(name + " joined the line");
                }
            }

            else if (command.equals("SERVE")) {

                if (size == 0) {
                    System.out.println("no one waiting");
                } else {
                    System.out.println("served " + queue[front]);

                    front = (front + 1) % 3;
                    size--;
                }
            }
        }

        sc.close();
    }
}
