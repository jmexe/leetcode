package com.jmexe.leetcode.SerializeAndDeserializeBinaryTree;

import java.util.Arrays;
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
    public String serialize(TreeNode root) {
        return buildString(root, "");
    }

    public String buildString(TreeNode root, String ans) {
        if (root == null) {
            ans += ",#";
            return ans;
        }

        if (ans.equals("")) {
            ans = "" + root.val;
        }
        else {
            ans += "," + root.val;
        }

        ans = buildString(root.left, ans);
        ans = buildString(root.right, ans);

        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.equals("")) {
            return null;
        }

        String[] tokens = data.split(",");
        Queue<String> q = new LinkedList<String>();
        q.addAll(Arrays.asList(tokens));

        return buildTree(q);
    }

    public TreeNode buildTree(Queue<String> q) {
        String val = q.poll();
        if (val.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = buildTree(q);
        root.right = buildTree(q);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Codec codec = new Codec();

        System.out.println(codec.serialize(codec.deserialize(codec.serialize(root))));
    }

}
