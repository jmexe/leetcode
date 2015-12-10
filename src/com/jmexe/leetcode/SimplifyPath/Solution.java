package com.jmexe.leetcode.SimplifyPath;

import java.util.Stack;

/**
 * Created by Jmexe on 12/7/15.
 */
public class Solution {
    public static String simplifyPath(String path) {
        String[] slices = path.split("/");

        Stack<String> stack = new Stack<String>();

        for (String folder : slices) {
            if (folder.equals(".") || folder.equals("")) {
                continue;
            }
            else if (folder.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                stack.push(folder);
            }
        }

        String ans = "/";
        while (!stack.isEmpty()) {
            ans = "/" + stack.pop() + ans;
        }

        if (ans.length() > 1) {
            return ans.substring(0, ans.length() - 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/abc/..."));
    }
}
