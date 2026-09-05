package Array.practiseproblems;

import java.util.*;

public class Price
 {

    static int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice)
                minPrice = prices[i];

            int profit = prices[i] - minPrice;

            if (profit > maxProfit)
                maxProfit = profit;
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] prices = new int[n];

        for (int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        int result = maxProfit(prices);

        System.out.println(result);

        sc.close();
    }
}