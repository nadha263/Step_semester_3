package Java_Arrays_and_Methods.practiseproblems;

import java.util.Arrays;
import java.util.Scanner;

public class TopScores {

    static int[] findTopThreeScores(int[] scores) {

        int first = 0;
        int second = 0;
        int third = 0;

        for (int i = 0; i < scores.length; i++) {

            int score = scores[i];

            if (score >= first) {
                third = second;
                second = first;
                first = score;
            }
            else if (score >= second) {
                third = second;
                second = score;
            }
            else if (score >= third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of teams: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter the scores:");

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        int[] result = findTopThreeScores(scores);

        System.out.println(Arrays.toString(result));

        sc.close();
    }
}
