package com.jmexe.leetcode.ZigZagCoversion;

/**
 * Created by Jmexe on 1/12/16.
 * https://leetcode.com/problems/zigzag-conversion/
 * level - easy
 */
public class Solution {
    public static String convert(String s, int numRows) {
        String[] lines = new String[numRows];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = "";
        }

        for (int i = 0; i < s.length(); i++) {
            int res = i % (2 * numRows - 2);
            if (res < numRows) {
                lines[res] += s.charAt(i);
            }
            else {
                lines[2 * numRows - 2 - res] += s.charAt(i);
            }
        }

        String ans = "";
        for (String line : lines) {
            ans += line;
        }

        return ans;
    }

    public static void main(String[] args) {
        String ans = convert("123456789abcdesfghijk", 4);
        System.out.println(ans);
    }
}
