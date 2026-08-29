package Week1.assignmentproblems;
import java.util.*;

public class TrafficSignalStreak {

    static void findLongestStreak(String signalLog) {

        int count = 1;
        int max = 1;
        char current = signalLog.charAt(0);
        char longest = current;

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count > max) {
                max = count;
                longest = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + longest +
                "' repeated " + max + " times");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter signal log: ");
        String signalLog = sc.nextLine();

        findLongestStreak(signalLog);

        sc.close();
    }
}