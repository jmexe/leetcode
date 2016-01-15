package com.jmexe.leetcode.MaximalRectangle;

/**
 * Created by Jmexe on 1/15/16.
 */
public class Solution {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rowN = matrix.length;
        int colN = matrix[0].length;


        int[][][] dps = new int[rowN][colN][2];

        dps[0][0] = matrix[0][0] == '0' ? new int[]{0, 0} : new int[]{1, 1};
        int max = Math.max(0, dps[0][0][0] * dps[0][0][1]);

        for (int i = 1; i < colN; i++) {
            if (matrix[0][i] - '0' == 0) {
                continue;
            }
            else {
                dps[0][i] = new int[]{dps[0][i - 1][0] + 1, 1};
            }

            max = Math.max(dps[0][i][0] * dps[0][i][1], max);
        }
        for (int i = 1; i < rowN; i++) {
            if (matrix[i][0] - '0' == 0) {
                continue;
            }
            else {
                dps[i][0] = new int[]{1, dps[i - 1][0][1] + 1};
            }

            max = Math.max(dps[i][0][0] * dps[i][0][1], max);
        }

        for (int i = 1; i < rowN; i++) {
            for (int j = 1; j < colN; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }

                int area1 = (dps[i][j - 1][0] + 1) * Math.min(dps[i][j - 1][1], dps[i - 1][j][1] + 1);
                int area2 = (dps[i - 1][j][1] + 1) * Math.min(dps[i][j - 1][0] + 1, dps[i - 1][j][0]);
                int area3 = (Math.min(dps[i - 1][j - 1][0], dps[i][j - 1][0]) + 1) * (Math.min(dps[i - 1][j][1], dps[i - 1][j - 1][1]) + 1);

                int subMax = Math.max(area1, Math.max(area2, area3));

                if (area1 == subMax) {
                    dps[i][j][0] = dps[i][j - 1][0] + 1;
                    dps[i][j][1] = Math.min(dps[i][j - 1][1], dps[i - 1][j][1] + 1);
                }
                else if (area2 == subMax) {
                    dps[i][j][0] = Math.min(dps[i][j - 1][0] + 1, dps[i - 1][j][0]);
                    dps[i][j][1] = dps[i - 1][j][1] + 1;
                }
                else {
                    dps[i][j][0] = Math.min(dps[i - 1][j - 1][0], dps[i][j - 1][0]) + 1;
                    dps[i][j][1] = Math.min(dps[i - 1][j][1], dps[i - 1][j - 1][1]) + 1;
                }

                max = Math.max(max, subMax);
            }
        }


        return max;
    }

    public static void main(String[] args) {
        String[] matrix_strs = {"1011100010","0100000110","0101000011","1110000010","0111001010","1101101110"};
        char[][] matrix = new char[matrix_strs.length][matrix_strs[0].length()];
        for (int i = 0; i < matrix_strs.length; i++) {
            for (int j = 0; j < matrix_strs[0].length(); j++) {
                matrix[i][j] = matrix_strs[i].charAt(j);
            }
        }

        System.out.println(maximalRectangle(matrix));
    }

}
