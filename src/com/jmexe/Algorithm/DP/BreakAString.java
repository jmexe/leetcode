package com.jmexe.Algorithm.DP;

/**
 * Created by Jmexe on 1/29/16.
 */
public class BreakAString {
    public static void main(String[] args) {
        int[] L = {0, 2, 8, 10, 20};
        int[][] c = new int[L.length + 1][L.length + 1];

        int m = L.length;

        for (int i = 1; i <= m - 1; i++) {
            c[i][i + 1] = 0;
        }

        for (int l = 2; l <= m - 1; l++) {
            for (int i = 1; i <= m - l; i++) {
                int j = i + l;
                c[i][j] = Integer.MAX_VALUE;

                for (int k = i + 1; k <= j - 1; k++) {
                    c[i][j] = Math.min(c[i][j], c[i][k] + c[k][j] + (L[j - 1] - L[i - 1]));
                }

            }
        }

        System.out.println(c[1][m]);
    }
}
