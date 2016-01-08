package com.jmexe.leetcode.RemoveDuplicatesFromSortedArray.QI;

/**
 * Created by Jmexe on 1/4/16.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * level - medium
 */
public class Solution {
    public static int removeDuplicates(int[] nums) {
        int pt = 0;
        int walker = 1;
        boolean isDpl = false;

        while (walker < nums.length) {
            while (isDpl && walker < nums.length && nums[walker] == nums[pt]) {
                walker++;
            }
            if (walker >= nums.length) {
                return pt + 1;
            }

            pt++;

            swap(nums, pt, walker);
            isDpl = (nums[pt] == nums[pt - 1]) ? true : false;
            walker++;
        }

        return pt + 1;
    }

    public static void swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        int ans = removeDuplicates(nums);
        System.out.println(ans);
    }
}
