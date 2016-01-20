package com.jmexe.leetcode.Sum.ThreeSumClosest;

import java.util.Arrays;

/**
 * Created by Jmexe on 1/11/16.
 */
public class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;


            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                closest = Math.abs(closest - target) > Math.abs(sum - target) ? sum : closest;

                if (sum == target) {
                    return target;
                }
                else if (sum < target) {
                    lo++;
                }
                else {
                    hi--;
                }
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0};
        int target = 100;
        System.out.println(threeSumClosest(nums, target));
    }
}
