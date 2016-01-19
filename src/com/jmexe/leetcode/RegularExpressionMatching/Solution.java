package com.jmexe.leetcode.RegularExpressionMatching;

/**
 * Created by Jmexe on 1/18/16.
 */
public class Solution {
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        if (p.length() == 1 || p.charAt(1) != '*') {
            if (s.isEmpty() || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {
                return false;
            }
            else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }

        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
            if (isMatch(s, p.substring(2))) {
                return true;
            }

            s = s.substring(1);
        }


        return isMatch(s, p.substring(2));
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab", "c*a*b"));
    }

}
