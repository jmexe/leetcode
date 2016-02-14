package com.jmexe.interview.WallsAndGates;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jmexe on 1/27/16.
 */
public class Solution {
    public static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int[][] directs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int rowN = rooms.length;
        int colN = rooms[0].length;

        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < rowN; i++) {
            for (int j = 0; j < colN; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(i * colN + j);
                }
            }
        }

        while (!q.isEmpty()) {
            int pos = q.poll();
            int row = pos / colN;
            int col = pos % colN;

            for (int[] direct : directs) {
                if (row + direct[0] >= 0 && row + direct[0] < rowN && col + direct[1] >= 0 && col + direct[1] < colN && rooms[row + direct[0]][col + direct[1]] == Integer.MAX_VALUE) {
                    rooms[row + direct[0]][col + direct[1]] = Math.min(rooms[row][col] + 1, rooms[row + direct[0]][col + direct[1]]);
                    q.offer(pos + direct[0] * colN + direct[1]);
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
