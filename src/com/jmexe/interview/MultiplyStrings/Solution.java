package com.jmexe.interview.MultiplyStrings;

/**
 * Created by Jmexe on 2/2/16.
 */
public class Solution {
    public static String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] arr = new int[len1 + len2];

        for (int i = len2 -1; i >= 0; i--) {
            int res = 0;
            for (int j = len1; j > 0; j--) {
                int sum = (num2.charAt(i) - '0') * (num1.charAt(j - 1) - '0') + res + arr[i + j];
                arr[j + i] = sum % 10;
                res = sum / 10;
            }
            arr[i] = res;
        }

        String ans = "";
        boolean zero = true;
        for (int i = 0; i < len1 + len2; i++) {
            if (zero && arr[i] == 0) {
                continue;
            }
            zero = false;
            ans += arr[i];
        }

        return ans.length() == 0 ? "0" : ans;
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

}
