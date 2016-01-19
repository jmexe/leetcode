package com.jmexe.lintcode.AdvancedLadder.KthLargestElement;

/**
 * Created by Jmexe on 1/18/16.
 * http://www.lintcode.com/en/problem/kth-largest-element/
 */
public class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public static int kthLargestElement(int k, int[] nums) {
        return findKth(nums, k, 0, nums.length - 1);
    }

    public static int findKth(int[] nums, int k, int start, int end) {
        int index = partition(nums, start, end);

        if (index - start == k - 1) {
            return nums[index];
        }
        else if (index - start < k - 1) {
            return findKth(nums, k - (index - start), index, end);
        }
        else {
            return findKth(nums, k, start, index);
        }
    }

    public static int partition(int[] nums, int start, int end) {
        // write your code here
        int pivot = nums[0];

        int lo = start, hi = end;

        while (lo <= hi) {
            while (nums[lo] < pivot) {
                lo++;
            }
            while (nums[hi] > pivot) {
                hi--;
            }

            if (lo <= hi) {
                int tmp = nums[lo];
                nums[lo] = nums[hi];
                nums[hi] = tmp;

                lo++;
                hi--;
            }
        }

        return lo;
    }

    public static void main(String[] args) {
        System.out.println(kthLargestElement(10, new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10, 7}));
    }

}
