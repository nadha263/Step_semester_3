package Encapsulation.assignmentproblems;

import java.util.Scanner;

public class TrafficLight {

    
    private String color;

   
    private final String id;

    
    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    
    public void next() {

        if (color.equals("RED")) {
            color = "GREEN";
        }
        else if (color.equals("GREEN")) {
            color = "YELLOW";
        }
        else if (color.equals("YELLOW")) {
            color = "RED";
        }
    }

    
    public String getColor() {
        return color;
    }

   
    public String getId() {
        return id;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter traffic light ID: ");
        String id = sc.nextLine();

        TrafficLight t = new TrafficLight(id);

        System.out.println("Current color: " + t.getColor());

        System.out.print("How many times should the light change? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            t.next();

            System.out.println("Current color: " + t.getColor());
        }

        sc.close();
    }
}