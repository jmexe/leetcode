package com.jmexe.leetcode.Sum.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jmexe on 12/27/15.
 */
public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        if (nums == null || nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);

        for (int p1 = 0; p1 < nums.length - 2; p1++) {
            if (p1 > 0 && nums[p1] == nums[p1 - 1]) {
                continue;
            }

            int lo = p1 + 1;
            int hi = nums.length - 1;


            while (lo < hi) {
                int sum = nums[p1] + nums[lo] + nums[hi];
                if (sum == 0) {
                    List<Integer> sol = new ArrayList<Integer>();
                    sol.add(nums[p1]);
                    sol.add(nums[lo]);
                    sol.add(nums[hi]);

                    ans.add(sol);

                    while (lo < hi && nums[lo] == nums[++lo]);
                }
                else if (sum < 0) {
                    while (lo < hi && nums[lo] == nums[++lo]);
                }
                else {
                    while (lo < hi && nums[hi] == nums[--hi]);
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> ans = threeSum(nums);
        for (List<Integer> sol : ans) {
            System.out.println(sol.toString());
        }
    }

}
