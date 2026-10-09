
package Abstraction.practiseproblems;

import java.util.*;

public class GardenPlotAreaReport {
    abstract static class Plot {
        String owner;

        Plot(String owner) {
            this.owner = owner;
        }

        abstract double calculateArea();

        abstract String getShape();
    }

    static class Circle extends Plot {
        double radius;

        Circle(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        double calculateArea() {
            return Math.PI * radius * radius;
        }

        String getShape() {
            return "CIRCLE";
        }
    }

    static class Rectangle extends Plot {
        double length, width;

        Rectangle(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        double calculateArea() {
            return length * width;
        }

        String getShape() {
            return "RECTANGLE";
        }
    }

    static class Triangle extends Plot {
        double base, height;

        Triangle(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        double calculateArea() {
            return 0.5 * base * height;
        }

        String getShape() {
            return "TRIANGLE";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of plots: ");
        int n = sc.nextInt();

        List<Plot> plots = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter shape (CIRCLE/RECTANGLE/TRIANGLE): ");
            String shape = sc.next().toUpperCase();

            System.out.print("Enter owner's name: ");
            String owner = sc.next();

            Plot plot;

            switch (shape) {
                case "CIRCLE":
                    System.out.print("Enter radius: ");
                    plot = new Circle(owner, sc.nextDouble());
                    break;

                case "RECTANGLE":
                    System.out.print("Enter length and width: ");
                    plot = new Rectangle(owner, sc.nextDouble(), sc.nextDouble());
                    break;

                case "TRIANGLE":
                    System.out.print("Enter base and height: ");
                    plot = new Triangle(owner, sc.nextDouble(), sc.nextDouble());
                    break;

                default:
                    System.out.println("Invalid shape");
                    i--;
                    continue;
            }

            plots.add(plot);
        }

        for (Plot plot : plots) {
            double area = plot.calculateArea();
            System.out.printf("%s (%s): %.2f%n",
                    plot.owner, plot.getShape(), area);
            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}