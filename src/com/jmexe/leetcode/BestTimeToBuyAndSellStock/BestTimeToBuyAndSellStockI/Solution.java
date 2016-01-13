package com.jmexe.leetcode.BestTimeToBuyAndSellStock.BestTimeToBuyAndSellStockI;

/**
 * Created by Jmexe on 1/13/16.
 * http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock/
 * from lintcode
 */
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = prices[0];

        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return max;
    }
}
