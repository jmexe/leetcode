package com.jmexe.leetcode.WildcardMathcing;

/**
 * Created by Jmexe on 12/6/15.
 * Wildcard Matching
 * https://leetcode.com/problems/wildcard-matching/
 * level -- hard
 */
public class Solution {
    public static boolean isMatch(String s, String p) {
        int pstar = -1;
        int pss = 0;

        int ps = 0, pt = 0;

        while (ps < s.length()) {
            if (pt < p.length() && (p.charAt(pt) == s.charAt(ps) || p.charAt(pt) == '?')) {
                ps++;
                pt++;
                continue;
            }

            if (pt < p.length() && p.charAt(pt) == '*') {
                pstar = pt++;
                pss = ps;
                continue;
            }

            if (pstar >= 0) {
                pt = pstar + 1;
                ps = ++pss;
                continue;
            }

            return false;
        }

        while (pt < p.length() && p.charAt(pt) == '*') {
            pt++;
        }

        return pt >= p.length();
    }

    public static void main(String[] args) {
        System.out.println(isMatch("ab", "?*"));
    }
}
