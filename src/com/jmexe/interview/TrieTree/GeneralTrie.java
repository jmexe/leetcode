package com.jmexe.interview.TrieTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jmexe on 1/28/16.
 */
public class GeneralTrie {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        boolean isTerminal = false;
    }

    static TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public static void addWord(String word) {
        TrieNode pt = root;
        for (char c : word.toCharArray()) {
            if (!pt.children.containsKey(c)) {
                pt.children.put(c, new TrieNode());
            }

            pt = pt.children.get(c);
        }

        pt.isTerminal = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public static boolean search(String word) {
        return searchHelper(word, root);
    }

    public static boolean searchHelper(String word, TrieNode node) {
        if (word.length() == 0) {
            return node.isTerminal;
        }

        if (word.charAt(0) != '.' && node.children.containsKey(word.charAt(0))) {
            return searchHelper(word.substring(1), node.children.get(word.charAt(0)));
        }

        if (word.charAt(0) == '.') {
            for (TrieNode child : node.children.values()) {
                if (searchHelper(word.substring(1), child)) {
                    return true;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        GeneralTrie trie = new GeneralTrie();
        trie.addWord("abc");
        trie.addWord("abd");
        trie.addWord("abe");
        trie.addWord("afc");


        System.out.println(trie.search("a.c"));
    }

}
