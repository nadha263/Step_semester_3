
package Java_Arrays_and_Methods.assignmentproblems;

import java.util.*;

class Ranking_Engine implements Comparable<Ranking_Engine> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

   
    Ranking_Engine(String name, int matchesPlayed,
                   double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

   
    public int compareTo(Ranking_Engine other) {
        return Double.compare(other.battingAverage,
                              this.battingAverage);
    }

    
    static String draftAndRank(Ranking_Engine[] players) {

        Ranking_Engine[] draftable =
            new Ranking_Engine[players.length];

        int count = 0;

        
        for (int i = 0; i < players.length; i++) {

            if (isDraftable(players[i].matchesPlayed) ||
                isDraftable(players[i].matchesPlayed,
                            players[i].injured)) {

                draftable[count] = players[i];
                count++;
            }
        }

        
        Arrays.sort(draftable, 0, count);

        String result = "";

        for (int i = 0; i < count; i++) {

            result = result + (i + 1) + ". "
                     + draftable[i].name;

            if (i < count - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();

        Ranking_Engine[] players =
            new Ranking_Engine[n];

        // Get input
        for (int i = 0; i < n; i++) {

            System.out.println("Enter player " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Matches played: ");
            int matches = sc.nextInt();

            System.out.print("Batting average: ");
            double average = sc.nextDouble();

            System.out.print("Injured (true/false): ");
            boolean injured = sc.nextBoolean();

            players[i] = new Ranking_Engine(
                name, matches, average, injured
            );
        }

        System.out.println();
        System.out.println(draftAndRank(players));

        sc.close();
    }
}