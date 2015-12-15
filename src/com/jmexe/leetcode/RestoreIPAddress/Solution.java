package com.jmexe.leetcode.RestoreIPAddress;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jmexe on 12/8/15.
 * Restore IP Addresses
 * https://leetcode.com/problems/restore-ip-addresses/
 * level - medium
 */
public class Solution {
    public static List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();

        if (s == null || s.length() < 4 || s.length() > 12) {
            return ans;
        }

        String trace = "";

        helper(ans, trace, s, 4);

        return ans;
    }

    public static void helper(List<String> ans, String trace, String s, int pos) {

        if (s.length() == 0) {
            return;
        }

        if (pos == 1) {
            if (s.length() > 0 && s.length() < 4 && Integer.parseInt(s) < 256) {

                if (s.charAt(0) == '0' && s.length() != 1) {
                    return;
                }

                trace += s;
                ans.add(trace);
            }

            return;
        }



        if (s.charAt(0) == '0') {
            trace += "0.";
            helper(ans, trace, s.substring(1), pos - 1);
        }

        else {
            for (int i = 1; i <= 3 && i < s.length(); i++) {
                if (Integer.parseInt(s.substring(0, i)) < 256) {
                    helper(ans, trace + s.substring(0, i) + ".", s.substring(i), pos - 1);
                }
            }
        }

    }

    public static void main(String[] args) {
        String s = "1980";
        List<String> ans = restoreIpAddresses(s);

        for (String sub : ans) {
            System.out.println(sub);
        }
    }
}
