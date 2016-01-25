package com.jmexe.interview.TrieTree;

import java.util.*;

/**
 * Created by Jmexe on 1/24/16.
 */

class Node {
    Map<Character, Node> children;
    boolean isTerminal;

    Node() {
        children = new HashMap<>();
        isTerminal = false;
    }

    Node getChildForLetter(char letter) {
        if (children.containsKey(letter)) {
            return children.get(letter);
        }
        return null;
    }

    boolean isTerminal() {
        return isTerminal;
    }
}

public class Solution {
    static Node root = new Node();

    public static void add(String word) {
        Node pt = root;
        for (char c : word.toCharArray()) {
            if (!pt.children.containsKey(c)) {
                pt.children.put(c, new Node());
            }
            pt = pt.children.get(c);
        }
        pt.isTerminal = true;
    }
    public static List<String> search(String word) {
        Set<String> ans = new HashSet<>();
        String trace = "";
        Node pt = root;
        searchHelper(ans, trace, word, pt);
        List<String> fS = new ArrayList<>();
        for (String sub : ans) {
            fS.add(sub);
        }
        return fS;
    }

    public static void searchHelper(Set<String> ans, String trace, String word, Node pt) {
        if (word.length() == 0) {
            if (pt.isTerminal) {
                ans.add(new String(trace));
            }
            return;
        }

        if (word.charAt(0) != '*') {
            if (pt.children.containsKey(word.charAt(0))) {
                trace += word.charAt(0);
                searchHelper(ans, trace, word.substring(1), pt.children.get(word.charAt(0)));
            }
        }
        else {
            for (char key : pt.children.keySet()) {
                searchHelper(ans, trace + key, word, pt.children.get(key));
                searchHelper(ans, trace + key, word.substring(1), pt.children.get(key));
            }
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.add("car");
        sol.add("caw");
        sol.add("cauw");

        List<String> ans = sol.search("c*w");
        for (String word : ans) {
            System.out.println(word);
        }
    }

}
