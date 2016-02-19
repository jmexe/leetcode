package com.jmexe.Algorithm.Sort;

/**
 * Created by Jmexe on 2/15/16.
 */
public class ShellSort {
    public static void qsort(int[] nums) {
        int N = nums.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && nums[j] < nums[j - h]; j -= h) {
                    swap(nums, j, j - h);
                }
            }

            h = h / 3;
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 5, 6, 8};
        qsort(nums);

        //int pv = partition(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
        System.out.println();

        //System.out.println(pv);

    }
}
