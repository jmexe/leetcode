package com.jmexe.leetcode.DifferentWaysToAddParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jmexe on 12/14/15.
 * Different Ways to Add Parentheses
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 * level - medium
 */
public class Solution {
    public static List<Integer> diffWaysToCompute(String input) {
        boolean flag = false;
        String num = "";
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '*' && input.charAt(i) != '+' && input.charAt(i) != '-') {
                num += input.charAt(i);
            }
            else {
                flag = true;
                List<Integer> lSet = diffWaysToCompute(input.substring(0, i));
                List<Integer> rSet = diffWaysToCompute(input.substring(i + 1));

                if (input.charAt(i) == '*') {
                    for (int l : lSet) {
                        for (int r : rSet) {
                            ans.add(l * r);
                        }
                    }
                }
                else if (input.charAt(i) == '+') {
                    for (int l : lSet) {
                        for (int r : rSet) {
                            ans.add(l + r);
                        }
                    }
                }
                else if (input.charAt(i) == '-') {
                    for (int l : lSet) {
                        for (int r : rSet) {
                            ans.add(l - r);
                        }
                    }
                }
            }
        }


        if (!flag) {
            ans.add(Integer.parseInt(num));
            return ans;
        }

        return ans;

    }

    public static void main(String[] args) {
        String input = "2*3-4*5";
        List<Integer> ans = diffWaysToCompute(input);
        for (int num : ans) {
            System.out.println(num);
        }
    }

}
