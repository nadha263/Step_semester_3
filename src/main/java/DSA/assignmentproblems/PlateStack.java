
package DSA.assignmentproblems;

import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    Node top;
    int size;

    Stack() {
        top = null;
        size = 0;
    }

    boolean isEmpty() {
        return top == null;
    }

    void push(String plate) {
        Node newNode = new Node(plate);
        newNode.next = top;
        top = newNode;
        size++;

        System.out.println("push " + plate + " -> top "
                + top.data + ", size " + size);
    }

    String pop() {
        if (isEmpty()) {
            System.out.println("pop -> stack is empty");
            return null;
        }

        String plate = top.data;
        top = top.next;
        size--;

        System.out.println("pop -> " + plate + ", size " + size);
        return plate;
    }

    String peek() {
        if (isEmpty()) {
            System.out.println("peek -> stack is empty");
            return null;
        }

        System.out.println("peek -> " + top.data);
        return top.data;
    }
}

public class PlateStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack stack = new Stack();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String operation = sc.next();

            if (operation.equals("push")) {
                String plate = sc.next();
                stack.push(plate);
            } else if (operation.equals("pop")) {
                stack.pop();
            } else if (operation.equals("peek")) {
                stack.peek();
            } else if (operation.equals("isEmpty")) {
                System.out.println("isEmpty -> " + stack.isEmpty());
            }
        }

        sc.close();
    }
}
