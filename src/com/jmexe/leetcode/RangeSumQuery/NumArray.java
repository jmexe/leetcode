package com.jmexe.leetcode.RangeSumQuery;

/**
 * Created by Jmexe on 1/11/16.
 * https://leetcode.com/problems/range-sum-query-mutable/
 * level - medium
 */
public class NumArray {
    class SegmentTreeNode {
        public int lo, hi;
        public int sum;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int lo, int hi, int sum) {
            this.lo = lo;
            this.hi = hi;
            this.sum = sum;

            left = null;
            right = null;
        }
    }

    SegmentTreeNode segTree = null;
    public SegmentTreeNode build(int lo, int hi, int[] nums) {
        if (lo > hi) {
            return null;
        }
        if (lo == hi) {
            return new SegmentTreeNode(lo, hi, nums[lo]);
        }

        int mid = (lo + hi) / 2;
        SegmentTreeNode lnode = build(lo, mid, nums);
        SegmentTreeNode rnode = build(mid + 1, hi, nums);

        SegmentTreeNode node = new SegmentTreeNode(lo, hi, lnode.sum + rnode.sum);
        node.left = lnode;
        node.right = rnode;

        return node;
    }

    public void updateTree(SegmentTreeNode root, int i, int val) {
        if (i < root.lo || i > root.hi) {
            return;
        }

        if ((root.lo == root.hi) && (root.lo == i)) {
            root.sum = val;
            return;
        }

        int mid = (root.lo + root.hi) / 2;
        if (i > mid) {
            updateTree(root.right, i, val);
        }
        else {
            updateTree(root.left, i, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }

    public int query(SegmentTreeNode root, int i , int j) {
        if (i > root.hi || j < root.lo) {
            return 0;
        }

        if (root.lo == i && root.hi == j) {
            return root.sum;
        }

        int mid = (root.lo + root.hi) / 2;

        if (i <= mid) {
            if (j <= mid) {
                return query(root.left, i, j);
            }
            else {
                return query(root.left, i, mid) + query(root.right, mid + 1, j);
            }
        }
        else {
            return query(root.right, i, j);
        }

    }

    public NumArray(int[] nums) {
        segTree = build(0, nums.length - 1, nums);
    }

    void update(int i, int val) {
        updateTree(segTree, i, val);
    }

    public int sumRange(int i, int j) {
        return query(segTree, i, j);
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}
