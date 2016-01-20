package com.jmexe.leetcode.Sum.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jmexe on 1/18/16.
 */
public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[j - 1] == nums[j] && j - 1 != i) {
                    continue;
                }

                int lo = j + 1;
                int hi = nums.length - 1;

                while (lo < hi) {
                    if (lo - 1 != j && nums[lo - 1] == nums[lo]) {
                        lo++;
                        continue;
                    }
                    if (hi < nums.length - 1 && nums[hi] == nums[hi + 1]) {
                        hi--;
                        continue;
                    }

                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];

                    if (sum == target) {
                        List<Integer> subans = new ArrayList<Integer>();
                        subans.add(nums[i]);
                        subans.add(nums[j]);
                        subans.add(nums[lo]);
                        subans.add(nums[hi]);
                        ans.add(subans);
                        lo++;
                    }
                    else if (sum > target) {
                        hi--;
                    }
                    else {
                        lo++;
                    }
                }

            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {-4, -3, 0, 0, 0, 1, 5};
        List<List<Integer>> ans = fourSum(nums, -6);

        for (List<Integer> subans : ans) {
            for (int num : subans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
