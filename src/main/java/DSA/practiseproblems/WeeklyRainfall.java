
package DSA.practiseproblems;

import java.util.Scanner;

public class WeeklyRainfall {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] rainfall = new double[7];

        double total = 0;
        double max = 0;

        int wettestDay = 0;
        int dryDays = 0;

        System.out.println("Enter rainfall for 7 days:");

        for (int i = 0; i < 7; i++) {

            rainfall[i] = sc.nextDouble();

            total = total + rainfall[i];

            if (rainfall[i] > max || i == 0) {
                max = rainfall[i];
                wettestDay = i;
            }

            if (rainfall[i] == 0) {
                dryDays++;
            }
        }

        double average = total / 7;

        System.out.print("Rainfall (mm): ");

        for (int i = 0; i < 7; i++) {
            System.out.print(rainfall[i] + " ");
        }

        System.out.println();

        System.out.printf("%nTotal Rainfall: %.1f mm%n", total);

        System.out.printf("Average Rainfall: %.2f mm%n", average);

        System.out.printf("Wettest Day: Day %d (%.1f mm)%n",
                wettestDay + 1, max);

        System.out.println("Total Dry Days: " + dryDays);

        sc.close();
    }
}
