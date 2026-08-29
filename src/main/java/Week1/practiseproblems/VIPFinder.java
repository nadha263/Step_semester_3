package Week1.practiseproblems;
import java.util.*;

public class VIPFinder{

    static String validateCustomerId(String customerId) {

        if (customerId.startsWith("VIP-"))
            return "VIP Customer";
        else
            return "Regular Customer";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        String customerId = sc.nextLine();

        String result = validateCustomerId(customerId);

        System.out.println(result);

        sc.close();
    }
}