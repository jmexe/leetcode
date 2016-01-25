package com.jmexe.interview.NumberOfislands;

/**
 * Created by Jmexe on 1/25/16.
 */
public class Solution {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rowN = grid.length;
        int colN = grid[0].length;

        int[] fathers = new int[rowN * colN];
        int[][] directs = {{-1, 0}, {0, -1}};

        int ans = 0;

        for (int i = 0; i < rowN * colN; i++) {
            int row = i / colN;
            int col = i % colN;

            if (grid[row][col] == '1') {
                ans++;
                fathers[i] = i;
                for (int[] direct : directs) {
                    if (row + direct[0] >= 0 && row + direct[0] < rowN && col + direct[1] >= 0 && col + direct[1] < colN && grid[row + direct[0]][col + direct[1]] == '1') {

                        if (father(fathers, i) != father(fathers, i + colN * direct[0] + direct[1])) {
                            ans--;
                            union(fathers, i, i + colN * direct[0] + direct[1]);
                        }
                    }
                }
            }
        }

        return ans;
    }

    public static void union(int[] fathers, int i, int j) {
        int rootI = father(fathers, i);
        int rootJ = father(fathers, j);

        if (rootI > rootJ) {
            fathers[rootI] = rootJ;
        }
        else if (rootI < rootJ) {
            fathers[rootJ] = rootI;
        }
    }

    public static int father(int[] fathers, int i) {
        while (fathers[i] != i) {
            i = fathers[i];
        }
        return i;
    }

    public static void main(String[] args) {
        String[] nums = {"1011011"};
        char[][] grid = new char[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            grid[i] = nums[i].toCharArray();
        }

        System.out.println(numIslands(grid));
    }

}
