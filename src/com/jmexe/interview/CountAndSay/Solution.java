package com.jmexe.interview.CountAndSay;

/**
 * Created by Jmexe on 1/27/16.
 */
public class Solution {
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String prev = countAndSay(n - 1);
        String ans = "";
        int cnt = 1;
        char t = prev.charAt(0);

        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) != t) {
                ans = ans + ((char) (cnt + 48)) + t;
                t = prev.charAt(i);
                cnt = 1;
                continue;
            }

            cnt++;
        }

        ans = ans + ((char) (cnt + 48)) + t;

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(2));
    }

}
