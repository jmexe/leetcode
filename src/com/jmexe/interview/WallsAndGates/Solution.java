package com.jmexe.interview.WallsAndGates;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jmexe on 1/27/16.
 */
public class Solution {
    public static void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        int[][] directs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < m * n; i++) {
            if (rooms[i / n][i % n] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int pos = q.poll();
            int row = pos / n, col = pos % n;
            for (int[] direct : directs) {
                if (row + direct[0] >= 0 && row + direct[0] < m && col + direct[1] >= 0 && col + direct[1] < n && rooms[row + direct[0]][col + direct[1]] == Integer.MAX_VALUE) {
                    rooms[row + direct[0]][col + direct[1]] = rooms[row][col] + 1;

                    q.offer((row + direct[0]) * n + col + direct[1]);
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] rooms = {{Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1},
                {Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1},
                {0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE}};

        wallsAndGates(rooms);

        for (int[] line : rooms) {
            for (int i : line) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

}
