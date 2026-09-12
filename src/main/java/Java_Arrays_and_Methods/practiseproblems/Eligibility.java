package Java_Arrays_and_Methods.practiseproblems;

import java.util.Arrays;
import java.util.Scanner;

class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;

    
    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // CGPA-only eligibility check
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    double getCompositeScore() {
        return cgpa * 10 + codingScore;
    }

    
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(),
                              this.getCompositeScore());
    }

    // Display candidate
    @Override
    public String toString() {
        return name + " (" + getCompositeScore() + ")";
    }

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted = new Candidate[candidates.length];

        int count = 0;

        for (int i = 0; i < candidates.length; i++) {

            if (isEligible(candidates[i].cgpa) ||
                isEligible(candidates[i].cgpa, candidates[i].codingScore)) {

                shortlisted[count] = candidates[i];
                count++;
            }
        }

      
        Candidate[] result = Arrays.copyOf(shortlisted, count);

        
        Arrays.sort(result);

        String output = "";

        for (int i = 0; i < result.length; i++) {

            output = output + (i + 1) + ". " + result[i];

            if (i < result.length - 1) {
                output = output + " | ";
            }
        }

        return output;
    }
}

public class Eligibility {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nCandidate " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = sc.nextInt();
            sc.nextLine();

            candidates[i] = new Candidate(name, cgpa, codingScore);
        }

        System.out.println("\nShortlisted Candidates:");

        System.out.println(
            Candidate.shortlistAndRank(candidates)
        );

        sc.close();
    }
}