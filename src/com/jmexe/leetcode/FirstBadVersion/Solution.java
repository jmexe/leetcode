package com.jmexe.leetcode.FirstBadVersion;

/**
 * Created by Jmexe on 1/12/16.
 * https://leetcode.com/problems/first-bad-version/
 * level - easy
 */
public class Solution {
    public static boolean isBadVersion(int n) {
        if (n < 1702766719) {
            return false;
        }

        return true;
    }

    public static int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;

        if (isBadVersion(1)) {
            return 1;
        }

        while (lo < hi) {
            int mid = (int) (((long)lo + (long)hi) / 2);

            if (isBadVersion(mid)) {
                hi = mid;
                if (lo == hi - 1) {
                    return hi;
                }
            }
            else {
                lo = mid;
            }

            if (lo == hi - 1) {
                return hi;
            }
        }

        return hi;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }

}
