package com.jmexe.interview.SqrtX;

/**
 * Created by Jmexe on 1/27/16.
 */
public class Solution {
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int lo = 1, hi = x;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid > x / mid) {
                hi = mid - 1;
            }
            else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }

                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

}
