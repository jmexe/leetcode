package com.jmexe.algorithms.QuickSort;

/**
 * Created by Jmexe on 2/13/16.
 */
public class QSort {
    public static void qsort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = partition(nums, lo, hi);
        qsort(nums, lo, pivot - 1);
        qsort(nums, pivot + 1, hi);
    }

    public static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];

        while (lo < hi) {
            while (lo < hi && nums[hi] >= pivot) --hi;
            nums[lo] = nums[hi];
            while (lo < hi && nums[lo] < pivot) ++lo;
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }

    public static void swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }

    public static int reversePartition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];

        while (lo < hi) {
            while (lo < hi && nums[hi] <= pivot) --hi;
            nums[lo] = nums[hi];
            while (lo < hi && nums[lo] > pivot) ++lo;
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }

    public static boolean checkPartition(int[] nums, int pivot) {
        for (int i = 0; i < nums.length; i++) {
            if ((i < pivot && nums[i] >= nums[pivot]) || (i > pivot && nums[i] < nums[pivot])) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkReversePartition(int[] nums, int pivot) {
        for (int i = 0; i < nums.length; i++) {
            if ((i < pivot && nums[i] <= nums[pivot]) || (i > pivot && nums[i] > nums[pivot])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 0};
        int pivot = reversePartition(nums, 0, nums.length - 1);
        System.out.println(checkReversePartition(nums, pivot));
    }

}
