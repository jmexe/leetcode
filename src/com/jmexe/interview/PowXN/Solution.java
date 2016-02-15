package com.jmexe.interview.PowXN;

/**
 * Created by Jmexe on 2/2/16.
 */
public class Solution {
    public static double myPow(double x, int n) {
        if (n == 0) {
            return (double)1;
        }

        if (n == 1) {
            return x;
        }

        if (n == 2) {
            return x * x;
        }

        boolean min = (n < 0);
        n = Math.abs(n);

        double half = myPow(x, n / 2);
        double ans = half * half;

        if (n % 2 == 1) {
            ans = x * ans;
        }

        if (min) {
            return 1 / ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(34.00515, -3));
    }

}
