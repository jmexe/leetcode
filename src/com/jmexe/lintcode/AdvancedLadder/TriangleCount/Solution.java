package com.jmexe.lintcode.AdvancedLadder.TriangleCount;

import java.util.Arrays;

/**
 * Created by Jmexe on 1/19/16.
 * http://www.lintcode.com/en/problem/triangle-count/
 */
public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public static int triangleCount(int S[]) {
        // write your code here
        Arrays.sort(S);
        int ans = 0;

        for (int i = 0; i < S.length - 2; i++) {
            for (int j = i + 1; j < S.length - 1; j++) {
                int hi = S.length - 1;
                while (hi > j) {
                    if (S[i] + S[j] <= S[hi]) {
                        hi--;
                    }
                    else {
                        ans += hi - j;
                        break;
                    }
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(triangleCount(new int[]{3, 4, 6, 7}));
    }

}
