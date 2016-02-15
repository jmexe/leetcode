package com.jmexe.interview.SortColors;

/**
 * Created by Jmexe on 2/14/16.
 */
public class Solution {
    public static void sortColors(int[] nums) {
        // write your code here
        int red = 0, blue = nums.length - 1;
        for (int white = 0; white < blue; white++) {
            if (white != red && nums[white] == 0) {
                swap(nums, red++, white--);
            }
            else if (white < blue && nums[white] == 2) {
                swap(nums, white--, blue--);
            }
        }
    }

    public static void swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,2,2,2,1,0,1,0,0,0,1,0,2,0};
        sortColors(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
