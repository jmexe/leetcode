package com.jmexe.interview.SortColorsII;

/**
 * Created by Jmexe on 2/11/16.
 */
public class Solution {
    public static void sortColors2(int[] colors, int k) {
        // write your code here
        helper(colors, 0, colors.length - 1, 1, k);
    }

    public static void helper(int[] colors, int start, int end, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int walker = start;

        while (walker <= end) {
            if (walker != start && colors[walker] == lo) {
                swap(colors, start++, walker);
            }
            else if (walker < end && colors[walker] == hi) {
                swap(colors, walker, end--);
            }
            else {
                walker++;
            }
        }

        helper(colors, start, end, ++lo, --hi);
    }


    public static void swap(int[] colors, int idx1, int idx2) {
        int tmp = colors[idx1];
        colors[idx1] = colors[idx2];
        colors[idx2] = tmp;
    }

    public static void main(String[] args) {
        int[] colors = {3, 2, 2, 1, 4};
        sortColors2(colors, 4);
        for (int num : colors) {
            System.out.println(num);
        }
    }
}
