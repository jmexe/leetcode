package com.jmexe.leetcode.WordSearch;

/**
 * Created by Jmexe on 1/4/16.
 */
public class Solution {
    public static int[][] directs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && helper(board, word.substring(1), visited, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }


    public static boolean helper(char[][] board, String word, boolean[][] visited, int x, int y) {
        if (word == null || word.length() == 0) {
            return true;
        }
        boolean ans = false;
        visited[x][y] = true;
        for (int[] direct : directs) {
            if (x + direct[0] >= 0 && x + direct[0] < board.length && y + direct[1] >= 0 && y + direct[1] < board[0].length && visited[x + direct[0]][y + direct[1]] == false && board[x + direct[0]][y + direct[1]] == word.charAt(0)) {

                ans |= helper(board, word.substring(1), visited, x + direct[0], y + direct[1]);
            }

        }
        visited[x][y] = false;
        return ans;
    }

    public static void main(String[] args) {
        char[][] board = {"ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()};
        String word = "ABCCED";

        System.out.println(exist(board, word));

    }
}
