package com.jmexe.Algorithm.Sort;

/**
 * Created by Jmexe on 2/3/16.
 */
public class QuickSort {
    public static void qsort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = partition(nums, lo, hi);
        qsort(nums, lo, pivot);
        qsort(nums, pivot + 1, hi);
    }


    public static int partition(int[] nums, int lo, int hi) {
        int pivot = lo;
        while (lo < hi) {
            while (lo < hi && nums[lo] < nums[pivot]) {
                lo++;
            }
            while (lo < hi && nums[hi] >= nums[pivot]) {
                hi--;
            }
            if (lo < hi) {
                swap(nums, lo++, hi--);
            }

        }
        swap(nums, pivot, lo);
        return hi;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 5, 6, 8};
        qsort(nums, 0, nums.length - 1);

        //int pv = partition(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
        System.out.println();

        //System.out.println(pv);

    }

}
