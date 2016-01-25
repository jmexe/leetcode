package com.jmexe.interview.ReversePrintLinkedList;

import com.jmexe.interview.LinkedListNode;

/**
 * Created by Jmexe on 1/24/16.
 * http://www.themianjing.com/2016/01/facebook%E9%9D%A2%E7%BB%8F%E4%B8%89%E8%BF%9E%E5%8F%91%E5%A5%89%E4%B8%8A/
 */
public class Solution {

    public static void reverPrint(LinkedListNode root) {
        //初始条件要注意,防止死循环
        LinkedListNode pt = root;
        LinkedListNode walker = null;

        while (pt != null) {
            LinkedListNode tmp = pt.next;
            pt.next = walker;
            walker = pt;
            pt = tmp;

        }

        while (walker != null) {
            System.out.println(walker.val);
            walker = walker.next;
        }
    }

    public static void recursionPrint(LinkedListNode root) {
        if (root.next != null)
            recursionPrint(root.next);
        System.out.println(root.val);
    }


    public static void main(String[] args) {
        LinkedListNode root = new LinkedListNode(new int[]{1, 2, 3, 4, 5});
        //reverPrint(root);
        recursionPrint(root);
    }
}
