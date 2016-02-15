package com.jmexe.interview.AlienDictionary;

import java.util.*;

/**
 * Created by Jmexe on 1/28/16.
 */
public class Solution {
    static Map<Character, LinkedList<Character>> graph = new HashMap<Character, LinkedList<Character>>();

    public static void buildGraph(String[] words) {
        for (int i = 0; i < words.length; i++) {
            boolean same = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (!graph.containsKey(words[i].charAt(j))) {
                    graph.put(words[i].charAt(j), new LinkedList<Character>());
                }

                if (i > 0 && same && words[i - 1].length() > j && words[i - 1].charAt(j) != words[i].charAt(j)) {
                    graph.get(words[i - 1].charAt(j)).add(words[i].charAt(j));
                    same = false;
                }
            }

        }
    }

    public static boolean tpSort(boolean[] visited, char c, Stack<Character> stack) {
        if (visited[c - 'a']) {
            return true;
        }

        visited[c - 'a'] = true;
        Iterator<Character> itr = graph.get(c).iterator();

        while (itr.hasNext()) {
            char next = itr.next();

            if ((visited[next - 'a'] && !stack.contains(next)) || !tpSort(visited, next, stack)) {
                return false;
            }
        }
        stack.push(c);
        return true;
    }

    public static String alienOrder(String[] words) {

        buildGraph(words);
        boolean[] visited = new boolean[26];
        Stack<Character> stack = new Stack<Character>();
        for (char c : graph.keySet()) {
            if (!visited[c - 'a'] && !tpSort(visited, c, stack)) {
                return "";
            }
        }

        String ans = "";

        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        //String[] words = {"wrt","wrf","er","ett","rftt"};
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(alienOrder(words));
    }

}
