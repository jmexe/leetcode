package com.jmexe.interview.KthLargestElementInAnArray;

/**
 * Created by Jmexe on 2/14/16.
 */
public class Solution {
    public static int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, k);
    }

    public static int helper(int[] nums, int start, int end, int k) {
        int pivot = partition(nums, start, end);
        if (pivot - start + 1 == k) {
            return nums[pivot];
        }
        else if (pivot - start + 1 > k) {
            return helper(nums, start, pivot - 1, k);
        }
        else {
            return helper(nums, pivot + 1, end, k - (pivot - start + 1));
        }
    }

    public static int partition(int[] nums, int lo, int hi) {
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

    public static void swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 0};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}
