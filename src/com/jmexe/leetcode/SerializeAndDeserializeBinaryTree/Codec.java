package com.jmexe.leetcode.SerializeAndDeserializeBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Jmexe on 1/11/16.
 * Serialize and Deserialize Binary Tree
 * level - medium
 * status - unfinished
 */

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        val = x;
    }
}

public class Codec {


    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        String ans = "";
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                ans += ",#";
                continue;
            }

            ans += "," + node.val;

            if (q.isEmpty() && node.left == null && node.right == null) {
                break;
            }
            q.offer(node.left);
            q.offer(node.right);
        }

        return ans.substring(1);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }

        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int i = 0;

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            if (++i < vals.length && !vals[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                q.offer(node.left);
            }

            if (++i < vals.length && !vals[i].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                q.offer(node.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(serialize(deserialize(serialize(root))));
    }

}
