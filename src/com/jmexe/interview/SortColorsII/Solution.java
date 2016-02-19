package com.jmexe.interview.SortColorsII;

/**
 * Created by Jmexe on 2/11/16.
 */
public class Solution {
    public static void sortColors2(int[] colors, int k) {
        // write your code here
        cSort(colors, k);
    }

    public static void cSort(int[] colors, int k) {
        //Initialize the counter
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] > 0) {
                int color = colors[i];
                if (colors[color - 1] > 0) {
                    colors[i--] = colors[color - 1];
                    colors[color - 1] = 0;
                }
                else {
                    colors[i] = 0;
                }
                colors[color - 1]--;
            }
        }

        int pt = colors.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            while (colors[i] < 0) {
                colors[i]++;
                colors[pt--] = i + 1;
            }
        }
    }

    public static void qSort(int[] colors, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = partition(colors, lo, hi);
        qSort(colors, lo, pivot - 1);
        qSort(colors, pivot + 1, hi);
    }

    public static int partition(int[] colors, int lo, int hi) {
        int pivot = colors[lo];
        while (lo < hi) {
            while (lo < hi && colors[hi] >= pivot) {
                hi--;
            }
            colors[lo] = colors[hi];
            while (lo < hi && colors[lo] < pivot) {
                lo++;
            }
            colors[hi] = colors[lo];
        }
        colors[lo] = pivot;
        return lo;
    }

    public static void main(String[] args) {
        int[] colors = {3, 2, 3, 3, 4, 3, 3, 2, 4, 4, 1, 2, 1, 1, 1, 3, 4, 3, 4, 2};
        sortColors2(colors, 4);
        for (int num : colors) {
            System.out.println(num);
        }
    }
}
