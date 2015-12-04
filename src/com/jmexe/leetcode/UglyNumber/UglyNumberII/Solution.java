package com.jmexe.leetcode.UglyNumber.UglyNumberII;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Jmexe on 12/3/15.
 */
public class Solution {
    public static int nthUglyNumber(int n) {
        Queue<Long> q = new PriorityQueue<Long>();

        q.offer((long)1);

        long ans = -1;
        for (int i = 0; i < n; i++) {
            while (q.peek() == ans) {
                q.poll();
            }

            ans = q.poll();


            q.offer(ans * 2);
            q.offer(ans * 3);
            q.offer(ans * 5);
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1024));
    }
}
