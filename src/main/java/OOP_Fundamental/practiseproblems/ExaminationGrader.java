
package OOP_Fundamental.practiseproblems;

import java.util.*;

public class ExaminationGrader {
    interface Question {
        double evaluate(String correct, String answer, double points);
    }

    static class MCQ implements Question {
        public double evaluate(String correct, String answer, double points) {
            return correct.equalsIgnoreCase(answer) ? points : 0;
        }
    }

    static class TF implements Question {
        public double evaluate(String correct, String answer, double points) {
            return correct.equalsIgnoreCase(answer) ? points : 0;
        }
    }

    static class Essay implements Question {
        public double evaluate(String correct, String answer, double points) {
            String[] keywords = correct.split(",");
            int count = 0;

            for (String keyword : keywords) {
                if (answer.toLowerCase().contains(keyword.trim().toLowerCase())) {
                    count++;
                }
            }

            if (count >= 2) {
                return points * 0.75;
            } else if (count == 1) {
                return points * 0.50;
            }

            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Question> graders = new HashMap<>();
        graders.put("MCQ", new MCQ());
        graders.put("TF", new TF());
        graders.put("ESSAY", new Essay());

        System.out.print("Enter number of questions: ");
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter question type (MCQ/TF/ESSAY): ");
            String type = sc.nextLine().trim().toUpperCase();

            System.out.print("Enter question text: ");
            String questionText = sc.nextLine();

            System.out.print("Enter correct answer or essay keywords: ");
            String correct = sc.nextLine();

            System.out.print("Enter student answer: ");
            String answer = sc.nextLine();

            System.out.print("Enter maximum points: ");
            double points = Double.parseDouble(sc.nextLine());

            Question grader = graders.get(type);
            double score = grader.evaluate(correct, answer, points);

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}