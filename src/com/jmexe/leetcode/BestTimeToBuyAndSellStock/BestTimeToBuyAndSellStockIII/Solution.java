package com.jmexe.leetcode.BestTimeToBuyAndSellStock.BestTimeToBuyAndSellStockIII;

/**
 * Created by Jmexe on 1/13/16.
 */
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] lTor = new int[prices.length];
        int[] rTol = new int[prices.length];

        int min = prices[0];
        int max = prices[prices.length - 1];

        int lMax = 0;
        int rMax = 0;

        for (int i = 1; i < prices.length; i++) {
            lTor[i] = Math.max(lMax, prices[i] - min);
            lMax = lTor[i];
            min = Math.min(prices[i], min);

            rTol[prices.length - 1 - i] = Math.max(rMax, max - prices[prices.length - 1 - i]);
            rMax = rTol[i];
            max = Math.max(prices[prices.length - 1 - i], max);
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, Math.max(0, lTor[i]) + Math.max(0, rTol[i]));
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 4, 7};
        System.out.println(maxProfit(prices));
    }
}
