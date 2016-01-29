package com.jmexe.interview.AlienDictionary;

import java.util.*;

/**
 * Created by Jmexe on 1/28/16.
 */
public class Solution {
    static Map<Character, LinkedList<Character>> graph = new HashMap<Character, LinkedList<Character>>();

    public static void buildGraph(String[] words) {
        for (int i = 0; i < words.length; i++) {
            boolean match = true;
            for (int j = 0; j < words[i].length(); j++) {
                if (!graph.containsKey(words[i].charAt(j))) {
                    graph.put(words[i].charAt(j), new LinkedList<Character>());
                }

                if (i > 0 && match && j < words[i - 1].length() && words[i - 1].charAt(j) != words[i].charAt(j)) {
                    graph.get(words[i - 1].charAt(j)).add(words[i].charAt(j));
                    match = false;
                }
            }
        }
    }

    public static boolean tpSort(boolean[] visited, boolean[] instack, char c, Stack<Character> stack) {
        visited[c - 'a'] = true;

        Iterator<Character> it = graph.get(c).iterator();

        while (it.hasNext()) {
            char next = it.next();
            if (visited[next - 'a'] && !instack[next - 'a']) {
                return false;
            }
            if (!visited[next - 'a']) {
                if( !tpSort(visited, instack, next, stack)) {
                    return false;
                }
            }
        }

        stack.push(c);
        instack[c - 'a'] = true;
        return true;
    }

    public static String alienOrder(String[] words) {

        buildGraph(words);

        boolean[] visited = new boolean[26];
        boolean[] instack = new boolean[26];
        Stack<Character> stack = new Stack<Character>();
        for (char c : graph.keySet()) {
            if (!visited[c - 'a']) {
                boolean valid = tpSort(visited, instack, c, stack);
                if (!valid) {
                    return "";
                }
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
        String[] words = {"a", "b", "a"};
        System.out.println(alienOrder(words));
    }

}
