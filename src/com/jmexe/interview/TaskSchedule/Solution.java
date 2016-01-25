package com.jmexe.interview.TaskSchedule;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jmexe on 1/24/16.
 */
public class Solution {
    public static void main(String[] args) {
        int[] tasks = {1, 2, 3, 1, 2, 3};
        int interval = 3;

        Queue<Integer> q = new LinkedList<Integer>();

        q.offer(tasks[0]);
        int ans = 1;
        int pos = 1;

        while (!q.isEmpty()) {
            if (pos >= tasks.length) {
                break;
            }

            if (q.contains(tasks[pos])) {
                q.offer(-1);
            }
            else {
                q.offer(tasks[pos]);
                pos++;
            }

            ans++;

            if (q.size() >= interval + 1) {
                q.poll();
            }

        }

        System.out.println(ans);

    }
}
