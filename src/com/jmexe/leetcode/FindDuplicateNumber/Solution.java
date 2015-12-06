package com.jmexe.leetcode.FindDuplicateNumber;

/**
 * Created by Jmexe on 12/6/15.
 * https://leetcode.com/problems/find-the-duplicate-number/
 * Difficulty - Hard
 */
public class Solution {
    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        int finder = 0;

        //Find the loop
        while (true)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast)
                break;
        }

        //Retrieve the duplicate number
        while (true)
        {
            slow = nums[slow];
            finder = nums[finder];
            if (slow == finder)
                return slow;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 5};
        System.out.println(findDuplicate(nums));
    }
}
