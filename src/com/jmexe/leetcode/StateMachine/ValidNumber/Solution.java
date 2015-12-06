package com.jmexe.leetcode.StateMachine.ValidNumber;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jmexe on 12/6/15.
 * Valid Number
 * https://leetcode.com/problems/valid-number/
 * level -- hard
 */
public class Solution {
    static class DFA {
        class Node {
            String mark;
            boolean valid;
            Map<Character, Node> hash;

            Node(String mark, boolean valid) {
                this.mark = mark;
                this.valid = valid;
                hash = new HashMap<Character, Node>();
            }
        }

        Node entry = new Node("entry", false);

        //construct the DFA
        DFA() {
            Node n1 = new Node("1", true);
            Node n2 = new Node("2", false);
            Node n3 = new Node("3", false);
            Node n4 = new Node("4", true);
            Node n5 = new Node("5", false);
            Node n6 = new Node("6", false);
            Node n7 = new Node("7", true);

            //Add the rel of digits
            for (char digit = '0'; digit <= '9'; digit++) {
                entry.hash.put(digit, n1);
                n2.hash.put(digit, n1);
                n1.hash.put(digit, n1);

                //n1.hash.put(digit, n4);
                n3.hash.put(digit, n4);
                n4.hash.put(digit, n4);

                n5.hash.put(digit, n7);
                n6.hash.put(digit, n7);
                n7.hash.put(digit, n7);
            }

            //Add the rel of +/-
            entry.hash.put('+', n2);
            entry.hash.put('-', n2);

            n5.hash.put('+', n6);
            n5.hash.put('-', n6);

            //Add the rel of '.'
            entry.hash.put('.', n3);
            n2.hash.put('.', n3);
            n1.hash.put('.', n4);

            //Add the rel of e/E
            n4.hash.put('e', n5);
            n4.hash.put('E', n5);

            n1.hash.put('e', n5);
            n1.hash.put('E', n5);

        }

        boolean query(String s) {
            Node state = entry;

            for (char c : s.toCharArray()) {
                if (state.hash.containsKey(c)) {
                    state = state.hash.get(c);
                }
                else {
                    return false;
                }
            }

            return state.valid;
        }

    }

    public static boolean isNumber(String s) {
        s = s.trim();
        DFA validitor = new DFA();
        return validitor.query(s);

    }

    public static void main(String[] args) {
        System.out.println(isNumber("-1."));
    }

}
