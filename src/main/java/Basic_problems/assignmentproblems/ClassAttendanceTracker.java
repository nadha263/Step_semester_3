package Basic_problems.assignmentproblems;

import java.util.Scanner;

public class ClassAttendanceTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] days = new int[n];

        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }

        int present = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int i = 0; i < n; i++) {
            if (days[i] == 1) {
                present++;
                currentStreak++;

                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        System.out.println("Present: " + present);
        System.out.println("Longest streak: " + longestStreak);
    }
}