package com.jmexe.interview.PopulatingNextRightPointersinEachNodeII;

/**
 * Created by Jmexe on 2/9/16.
 */

class TreeLinkNode{
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) {val = x;}
}

public class Solution {
    public static void connect(TreeLinkNode root) {
        helper(root, null);
    }

    public static void helper(TreeLinkNode root, TreeLinkNode prev) {
        if (root == null) {
            return;
        }

        if (prev == null) {
            root.next = null;
        }

        while (prev != null) {
            if (prev.left != null) {
                if (root == prev.left) {
                    continue;
                }
                root.next = prev.left;
                break;
            }

            if (prev.right != null) {
                root.next = prev.right;
                break;
            }

            prev = prev.next;
        }

        if (root.left != null) {
            helper(root.left, root);
        }

        if (root.right != null) {
            helper(root.right, root.next);
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        connect(root);
    }
}
