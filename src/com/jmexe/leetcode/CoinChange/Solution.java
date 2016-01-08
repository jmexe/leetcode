package com.jmexe.leetcode.CoinChange;

import java.util.Arrays;

/**
 * Created by Jmexe on 1/4/16.
 */
public class Solution {
    public static int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);
        if (amount == 0) {
            return 0;
        }
        if (amount < coins[0]) {
            return -1;
        }

        int[] dps = new int[amount];
        //Initialize
        for (int i = 0; i < coins[0] - 1; i++) {
            dps[i] = -1;
        }

        for (int coin : coins) {
            if (coin <= amount) {
                dps[coin - 1] = 1;
            }
        }

        //DP
        for (int i = coins[0]; i < amount; i++) {
            if (dps[i] == 0) {
                dps[i] = -1;
                for (int coin : coins) {
                    if (i - coin >= 0 && dps[i - coin] != -1) {
                        if (dps[i] == -1) {
                            dps[i] = dps[i - coin] + 1;
                        }
                        else {
                            dps[i] = Math.min(dps[i], dps[i - coin] + 1);
                        }
                    }
                }
            }
        }

        return dps[amount - 1];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1}, 2));
    }
}
