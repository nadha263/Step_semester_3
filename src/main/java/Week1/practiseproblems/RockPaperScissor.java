package Week1.practiseproblems;
import java.util.*;

public class RockPaperScissor {

    static String playRound(String player, String computer) {

        if (player.equals(computer))
            return "Draw";

        if ((player.equals("Rock") && computer.equals("Scissors")) ||
            (player.equals("Paper") && computer.equals("Rock")) ||
            (player.equals("Scissors") && computer.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        String[] player = new String[5];
        String[] computer = new String[5];
        String[] result = new String[5];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < 5; i++) {

            System.out.print("Enter Rock/Paper/Scissors: ");
            player[i] = sc.next();

            computer[i] = moves[r.nextInt(3)];

            result[i] = playRound(player[i], computer[i]);

            System.out.println("Round " + (i + 1));
            System.out.println("Player: " + player[i]);
            System.out.println("Computer: " + computer[i]);
            System.out.println(result[i]);
            System.out.println();

            if (result[i].equals("Player Wins"))
                wins++;
            else if (result[i].equals("Computer Wins"))
                losses++;
            else
                draws++;
        }

        
        System.out.println("----- Final Summary -----");
        System.out.println("Round  Player  Computer  Result");

        for (int i = 0; i < 5; i++)
            System.out.println((i + 1) + "      " + player[i] + "    " +
                    computer[i] + "    " + result[i]);

        double winPercent = wins * 100.0 / 5;

        System.out.println();
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercent + "%");

        sc.close();
    }
}