package com.jmexe.interview.NumberOfConnectedComponentsInAnUndirectedGraph;

import java.util.Arrays;

/**
 * Created by Jmexe on 1/29/16.
 */
public class Solution {
    public static int countComponents(int n, int[][] edges) {
        int[] fathers = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(fathers, -1);
        int ans = 0;
        for (int[] edge : edges) {
            if (!visited[edge[0]] && !visited[edge[1]]) {
                ans++;
                union(fathers, edge[0], edge[1]);
            }
            else if (visited[edge[0]] && visited[edge[1]]) {
                int f1 = find(fathers, edge[0]);
                int f2 = find(fathers, edge[1]);

                if (f1 != f2) {
                    ans--;
                    fathers[f1] = f2;
                }
            }
            else {
                union(fathers, edge[0], edge[1]);
            }

            visited[edge[0]] = true;
            visited[edge[1]] = true;
        }

        for (boolean visit : visited) {
            if (!visit) {
                ans++;
            }
        }

        return ans;
    }

    public static void union(int[] fathers, int i, int j) {
        int fi = find(fathers, i);
        int fj = find(fathers, j);
        fathers[fi] = fj;
    }

    public static int find(int[] fathers, int i) {
        if (fathers[i] < 0) {
            return i;
        }

        return find(fathers, fathers[i]);
    }

    public static void main(String[] args) {
        System.out.println(countComponents(4, new int[][] {{2, 3}, {1, 2}, {1, 3}}));
    }
}
