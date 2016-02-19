package com.jmexe.Algorithm.Sort;

/**
 * Created by Jmexe on 2/15/16.
 */
public class InsertionSort {
    public static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j> 0 && nums[j] < nums[j - 1]; j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    public static void swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 1, 2, 3};
        sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
