package com.jmexe.leetcode.MinStack;

import java.util.Stack;

/**
 * Created by Jmexe on 12/17/15.
 * Min Stack
 * https://leetcode.com/problems/min-stack/
 * Level - Easy
 * This is an one stack solution
 */
public class Solution {
    static class MinStack {
        Stack<Integer> stack = new Stack<Integer>();
        int min = Integer.MAX_VALUE;

        //Push function
        //When the value is smaller than the current min value, will push the current min value into the stack first
        public void push(int x) {

            if (x <= min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        //When the top of the stack is equal to the current min value,will pop one more time to get the previous min value
        public void pop() {
            int peek = stack.pop();
            if (peek == min) {
                min = stack.peek();
                stack.pop();
            }

            if (stack.isEmpty()) {
                min = Integer.MAX_VALUE;
            }

        }

        //Return the top of the stack
        public int top() {
            return stack.peek();
        }

        //Return the current min value
        public int getMin() {
            return min;
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(2147483646);
        stack.push(2147483646);
        stack.push(2147483647);

        stack.top();
        stack.pop();
        stack.getMin();
        stack.pop();
        stack.getMin();
        stack.pop();
        stack.push(2147483647);

        stack.top();
        stack.getMin();

        stack.push(-2147483648);
        stack.top();
        stack.getMin();
        stack.pop();
        stack.getMin();

    }

}
