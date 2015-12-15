package com.jmexe.leetcode.LargestNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Jmexe on 12/7/15.
 */
public class Solution {
    public static String largestNumber(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
        }

        Comparator<Integer> cmp = new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2) {
                if (n1.equals(n2)) {
                    return 0;
                }

                String s1 = "" + n1;
                String s2 = "" + n2;

                for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
                    int diff = s2.charAt(i) - s1.charAt(i);

                    if (diff != 0) {
                        return diff;
                    }
                }

                return s1.length() > s2.length() ? -1 : 1;
            }
        };

        Collections.sort(list, cmp);

        String ans = "";
        for (int num : list) {
            ans += num;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(largestNumber(nums));
    }
}
