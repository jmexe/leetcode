package com.jmexe.leetcode.MinimumWindowSubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jmexe on 12/6/15.
 * Minimum Window Substring
 * https://leetcode.com/problems/minimum-window-substring/
 * level - hard
 */
public class Solution {
    //TODO optimize
    public static String minWindow(String s, String t) {
        if (s.equals(t)) {
            return s;
        }

        Map<Character, Integer> hash = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            if (!hash.containsKey(c)) {
                hash.put(c, 0);
            }
            hash.put(c, hash.get(c) + 1);
        }

        int lo = 0, hi = 0;

        for (int i = 0; i < s.length(); i++) {
            if (hash.containsKey(s.charAt(i))) {
                lo = i;
                hi = i;
                break;
            }
        }

        int min = Integer.MAX_VALUE;
        int[] pair = {-1, -1};
        int size = 0;

        while (lo <= s.length() - t.length()) {
            while (size < t.length() && hi < s.length()) {
                if (hash.containsKey(s.charAt(hi))) {
                    hash.put(s.charAt(hi), hash.get(s.charAt(hi)) - 1);

                    if (hash.get(s.charAt(hi)) >= 0) {
                        size++;
                    }
                }
                hi++;
            }

            if (size == t.length()) {

                if (hi - lo < min) {
                    min = hi - lo;
                    pair[0] = lo;
                    pair[1] = hi;
                }


                if (hash.get(s.charAt(lo)) >= 0) {
                    size--;
                }
                hash.put(s.charAt(lo), hash.get(s.charAt(lo)) + 1);
                lo++;


                while (lo < hi && !hash.containsKey(s.charAt(lo))) {
                    lo++;
                }

            }
            else {
                lo++;
            }
        }

        if (pair[0] >= 0) {
            return s.substring(pair[0], pair[1]);
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ab", "b"));
    }

}
