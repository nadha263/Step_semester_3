package Week2.assignmentproblems;
import java.util.*;

public class WordFrequency {

    static void printFilteredWordFrequency(String feedback) {

        
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        
        feedback = feedback.toLowerCase();
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");

        String[] words = feedback.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();

        
        for (int i = 0; i < words.length; i++) {

            boolean stop = false;

            for (int j = 0; j < stopWords.length; j++) {
                if (words[i].equals(stopWords[j])) {
                    stop = true;
                    break;
                }
            }

            if (!stop)
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        
        ArrayList<String> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> map.get(b) - map.get(a));

        
        for (String word : list)
            System.out.println(word + ": " + map.get(word));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}