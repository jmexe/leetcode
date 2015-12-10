package com.jmexe.leetcode.BurstBalloons;

import java.util.ArrayList;

/**
 * Created by Jmexe on 12/3/15.
 */
public class Solution {
    public static int maxCoins(int[] inums) {
        int[] nums = new int[inums.length + 2];
        int n = 1;
        for (int x : inums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k) {
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        //System.out.println(maxCoins(new int[] {7,9,8,0,7,1,3,5,5,2,3}));
        System.out.println(maxCoins(new int[] {3, 1, 5, 8}));
    }
}
