package com.jmexe.leetcode.TheSkylineProblem;

import java.util.*;

/**
 * Created by Jmexe on 1/18/16.
 */
public class Solution {
    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ans = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        for (int[] b : buildings) {
            height.add(new int[] {b[0], -b[2]});
            height.add(new int[] {b[1], b[2]});
        }

        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        Queue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
        q.offer(0);
        int prev = 0;

        for (int[] h : height) {
            if (h[1] < 0) {
                q.offer(-h[1]);
            }
            else {
                q.remove(h[1]);
            }

            int current = q.peek();
            if (current != prev) {
                ans.add(new int[] {h[0], current});
                prev = current;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] buildings = {{0, 1, 3}};
        List<int[]> ans = getSkyline(buildings);
        for (int[] line : ans) {
            System.out.println(line.toString());
        }
    }

}
