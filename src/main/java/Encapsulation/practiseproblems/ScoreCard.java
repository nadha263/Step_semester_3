package Encapsulation.practiseproblems;

import java.util.Scanner;

public class ScoreCard {

    private boolean[] results;
    private int count;
    private int score;

    
    ScoreCard(int totalQuestions) {
        results = new boolean[totalQuestions];
        count = 0;
        score = 0;
    }

    
    void recordAnswer(boolean correct) {
        if (count < results.length) {
            results[count] = correct;
            count++;

            if (correct) {
                score++;
            }
        } else {
            System.out.println("No more answers can be recorded.");
        }
    }

   
    int getScore() {
        return score;
    }

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of questions: ");
        int n = sc.nextInt();

        ScoreCard card = new ScoreCard(n);

        for (int i = 0; i < n; i++) {
            System.out.print("Enter answer result (true/false): ");
            boolean answer = sc.nextBoolean();

            card.recordAnswer(answer);
        }

        System.out.println("Final Score = " + card.getScore());

        sc.close();
    }
}
