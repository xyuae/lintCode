/**
 * Created by Xiaojun YU on 2017-02-19.
 */
public class GreedyStockIII {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     * Use dynamic programming and forward-backward traversal
     * left[] keeps the profit form start to sell at ith point
     * right[] the other way around
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        // write your code here
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        // DP from left to right;
        left[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++){
            min = Math.min(prices[i], min);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--){
            max = Math.max(prices[i], max);
            right[i] = Math.max(right[i + 1], max - prices[i]);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++){
            profit = profit < left[i] + right[i] ? left[i] + right[i] : profit;
        }
        return profit;
    }
}
