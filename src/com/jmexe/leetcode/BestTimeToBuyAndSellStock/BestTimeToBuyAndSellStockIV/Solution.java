package com.jmexe.leetcode.BestTimeToBuyAndSellStock.BestTimeToBuyAndSellStockIV;

/**
 * Created by Jmexe on 1/13/16.
 * http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock-iv/
 * from lintcode
 */
public class Solution {
    /**
     * The DP will traverse the array for k + 1 times
     * dps[i][j] = max {dps[i][j - 1], prices[j] + profit}
     * profit is the max value of previous trades - previous price
     * so prices[j] + profit would be the the best profit at day j
     *
     * If K >= prices.length / 2, we can achieve the max profit, since we just need to buy the stock at day i
     * when the price of that stock at day i + 1 will rise, it will take at most prices.length / 2 trasanctions
     *
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        if (k > prices.length / 2) {
            int ans = 0;
            for (int i = 1; i < prices.length; i++) {
                ans += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
            }
            return ans;
        }

        // write your code here
        int[][] dps = new int[k + 1][prices.length];

        for (int i = 1; i <= k; i++) {
            int profit = 0 - prices[0];
            for (int j = 1; j < prices.length; j++) {
                dps[i][j] = Math.max(dps[i][j - 1], prices[j] + profit);
                profit = Math.max(dps[i - 1][j - 1] - prices[j], profit);
            }
        }
        return dps[k][prices.length - 1];
    }
}
