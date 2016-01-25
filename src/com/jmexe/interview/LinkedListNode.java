package com.jmexe.interview;

/**
 * Created by Jmexe on 1/24/16.
 */
public class LinkedListNode {
    public int val;
    public LinkedListNode next;

    LinkedListNode(int c) {
        this.val = c;
        this.next = null;
    }

    public LinkedListNode(int[] vals) {
        this.val = vals[0];
        LinkedListNode pt = this;
        for (int i = 1; i < vals.length; i++) {
            pt.next = new LinkedListNode(vals[i]);
            pt = pt.next;
        }
    }
}
