package com.jmexe.leetcode.BestTimeToBuyAndSellStock.BestTimeToBuyAndSellStockII;

/**
 * Created by Jmexe on 1/13/16.
 * http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock-ii/
 * from lintcode
 */
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }
        return profit;
    }
}
