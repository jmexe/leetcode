package com.jmexe.Algorithm.Sort;

/**
 * Created by Jmexe on 2/15/16.
 */
public class qSort {
    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    public static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition(nums, start, end);
        sort(nums, start, pivot - 1);
        sort(nums, pivot + 1, end);
    }

    public static int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        while (start < end) {
            while (end > start && nums[end] >= pivot) {
                end--;
            }
            nums[start] = nums[end];
            while (end > start && nums[start] < pivot) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = pivot;
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, 0};
        sort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
