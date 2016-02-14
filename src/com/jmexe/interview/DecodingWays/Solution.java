package com.jmexe.interview.DecodingWays;

/**
 * Created by Jmexe on 2/9/16.
 */
public class Solution {
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] dps = new int[s.length() + 1];
        dps[0] = 1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dps[i + 1] += dps[i];
            }
            if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7'))) {
                dps[i + 1] += dps[i - 1];
            }

        }

        return dps[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("11"));
    }
}
