package com.jmexe.leetcode.SortList;

/**
 * Created by Jmexe on 12/17/15.
 * Sort List
 * https://leetcode.com/problems/sort-list/
 * level - medium
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rHead = slow.next;
        slow.next = null;

        ListNode lHead = sortList(head);
        rHead = sortList(rHead);

        if (lHead == null) {
            return rHead;
        }
        else if (rHead == null) {
            return lHead;
        }
        else {
            head = new ListNode(-1);
            ListNode pt = head;

            while (lHead != null && rHead != null) {
                if (lHead.val > rHead.val) {
                    pt.next = rHead;
                    pt = pt.next;
                    rHead = rHead.next;
                }
                else {
                    pt.next = lHead;
                    pt = pt.next;
                    lHead = lHead.next;
                }
            }

            if (lHead != null) {
                pt.next = lHead;
            }
            else if (rHead != null) {
                pt.next = rHead;
            }

            return head.next;
        }

    }


    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        ListNode head = new ListNode(-1);
        ListNode pt = head;

        for (int i : nums) {
            pt.next = new ListNode(i);
            pt = pt.next;
        }

        head = head.next;

        head = sortList(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

}
