package Basic_problems.assignmentproblems;

import java.util.Scanner;

public class SecondBestScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        int highest = -1;
        int second = -1;

        for (int i = 0; i < n; i++) {
            int score = scores[i];

            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }

        System.out.println(second);
    }
}