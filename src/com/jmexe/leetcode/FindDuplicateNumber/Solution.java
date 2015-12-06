package com.jmexe.leetcode.FindDuplicateNumber;

/**
 * Created by Jmexe on 12/6/15.
 * https://leetcode.com/problems/find-the-duplicate-number/
 * Difficulty - Hard
 */
public class Solution {
    //TODO optimize
    public static int findDuplicate(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int slow = nums[i] - 1;
            int fast = nums[i] - 1;

            if (nums[i] == i + 1) {
                continue;
            }

            while (fast != i) {
                slow = nums[slow] - 1;
                fast = nums[fast] - 1;

                if (fast != i) {
                    fast = nums[fast] - 1;
                }
                else {
                    break;
                }

                if (fast == slow) {
                    break;
                }
            }

            if (fast == i) {
                continue;
            }
            else {
                int pt = nums[i] - 1;

                if (pt == slow) {
                    while (nums[pt] - 1 != slow) {
                        pt = nums[pt] - 1;
                    }
                }

                else {
                    while (nums[pt] != nums[slow]) {
                        pt = nums[pt] - 1;
                        slow = nums[slow] - 1;
                    }
                }

                return nums[pt];
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1};
        System.out.println(findDuplicate(nums));
    }
}
