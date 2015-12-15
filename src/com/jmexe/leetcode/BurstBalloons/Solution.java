package com.jmexe.leetcode.BurstBalloons;

import java.util.ArrayList;

/**
 * Created by Jmexe on 12/3/15.
 */
public class Solution {
    public static int maxCoins(int[] inums) {
        int n = inums.length;
        int[] nums = new int[n + 2];
        for (int i = 0; i < n; i++) nums[i + 1] = inums[i];
        nums[0] = nums[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n - k + 1; i++) {
                int j = i + k - 1;
                for (int x = i; x <= j; x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][x - 1] + nums[i - 1] * nums[x] * nums[j + 1] + dp[x + 1][j]);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        //System.out.println(maxCoins(new int[] {7,9,8,0,7,1,3,5,5,2,3}));
        System.out.println(maxCoins(new int[] {3, 1, 5, 8}));
    }
}
