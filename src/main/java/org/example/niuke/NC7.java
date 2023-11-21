package org.example.niuke;

/**
 * @ClassName NC7 买卖股票的最好时机
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/31 13:18
 * @Version 1.0
 */
public class NC7 {
    public int maxProfit (int[] prices) {
        if(prices.length == 0) return 0;
        int res = 0 ;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                res = prices[j] - prices[i];
                max= Math.max(max,res);
            }
        }
        return Math.max(max,0);
        // write code here
    }

    public int maxProfit2 (int[] prices) {
        if(prices.length == 0) return 0;
       int min = Integer.MAX_VALUE;
       int max= 0;
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return max;
        // write code here
    }


}
