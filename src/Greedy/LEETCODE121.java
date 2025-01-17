package Greedy;

import java.util.Stack;

public class LEETCODE121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices) {
            if(price < min) {
                min = price;
            }
            else if(price - min > maxProfit) {
                maxProfit  = price - min;
            }
        }

        return maxProfit;
    }
}
