package com.jmexe.interview.RandomlyReturnTheIndexOfMaximumElementsInTheArray;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jmexe on 1/24/16.
 */
public class Solution {
    public static int randomPick(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        int index = -1;


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                cnt = 1;
                index = i;
            }

            else if (nums[i] == max) {
                cnt++;
                if ((int)(Math.random() * cnt) == 0) {
                    index = i;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {

        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        int[] nums = {1, 1, 2, 3, 3, 3, 3, 2};
        int t = 1000;
        while (t-- > 0) {
            int index = randomPick(nums);
            if (!hash.containsKey(index)) {
                hash.put(index, 0);
            }
            hash.put(index, hash.get(index) + 1);
        }
        for (int times : hash.values()) {
            System.out.println(times);
        }
    }
}
