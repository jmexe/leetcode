package com.jmexe.interview.CourseScheduleII;

import java.util.*;

/**
 * Created by Jmexe on 2/1/16.
 */
public class Solution {
    static Map<Integer, LinkedList<Integer>> graph = new HashMap<Integer, LinkedList<Integer>>();

    public static void buildGraph(int[][] prerequisites) {
        for (int[] edge : prerequisites) {
            if (!graph.containsKey(edge[1])) {
                graph.put(edge[1], new LinkedList<Integer>());
            }
            graph.get(edge[1]).add(edge[0]);
        }
    }

    public static boolean tpSort(boolean[] visited, Stack<Integer> stack, int num) {
        if (visited[num]) {
            return true;
        }

        if (!graph.containsKey(num)) {
            visited[num] = true;
            stack.push(num);
            return true;
        }

        Iterator<Integer> it = graph.get(num).iterator();
        visited[num] = true;
        while (it.hasNext()) {
            Integer next = it.next();
            if (visited[next] && !stack.contains(next)) {
                return false;
            }

            if (!tpSort(visited, stack, next)) {
                return false;
            }
        }
        stack.push(num);
        return true;
    }


    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Stack<Integer> stack = new Stack<Integer>();
        buildGraph(prerequisites);
        boolean[] visited = new boolean[numCourses];
        for (int num : graph.keySet()) {

            if (!tpSort(visited, stack, num)) {
                return new int[]{};
            }
        }

        for (int num = 0; num < numCourses; num++) {
            if (!visited[num]) {
                stack.push(num);
            }
        }


        int[] ans = new int[numCourses];
        int pt = 0;
        while (!stack.isEmpty()) {
            ans[pt++] = stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] ans = findOrder(3, new int[][] {{1, 0}, {2, 0}});
    }

}
