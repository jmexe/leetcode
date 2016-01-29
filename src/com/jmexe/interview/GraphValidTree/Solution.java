package com.jmexe.interview.GraphValidTree;

import java.util.Arrays;

/**
 * Created by Jmexe on 1/28/16.
 */
public class Solution {
    public static boolean validTree(int n, int[][] edges) {
        int[] roots = new int[n];
        Arrays.fill(roots, -1);

        for (int[] edge : edges) {
            int rx = find(roots, edge[0]);
            int ry = find(roots, edge[1]);
            if (rx == ry) {
                return false;
            }

            roots[rx] = ry;
        }
        return true;
    }

    public void union(int[] roots, int i, int j) {
        int ri = find(roots, i);
        int rj = find(roots, j);

        if (ri != rj) {
            roots[ri] = rj;
        }
    }

    public static int find(int[] roots, int n) {
        if (n < 0) {
            return n;
        }

        return find(roots, roots[n]);
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        System.out.println(validTree(5, edges));
    }

}
