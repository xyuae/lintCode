/**
 * Created by Xiaojun YU on 2017-02-19.
 */
public class GreedyStock {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     * Use greedy algorithm, always buy the stock at minimum point
     * sell stock at maximum point after the minimum point
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i : prices) {
            min = i < min ? i : min;
            profit = (i - min) > profit ? i - min : profit;
        }
        return profit;
    }
}
