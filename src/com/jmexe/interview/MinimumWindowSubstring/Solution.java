package com.jmexe.interview.MinimumWindowSubstring;

/**
 * Created by Jmexe on 1/24/16.
 */
public class Solution {
    public static String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int lo = 0, hi = 0, cnt = t.length(), max = Integer.MAX_VALUE;
        String ans = "";

        while (hi < s.length()) {
            if (map[s.charAt(hi++)]-- > 0) {
                cnt--;
            }
            while (cnt == 0) {
                if (hi - lo < max) {
                    max = hi - lo;
                    ans = s.substring(lo, hi);
                }

                if (map[s.charAt(lo++)]++ == 0) {
                    cnt++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("a", "aa"));
    }
}
