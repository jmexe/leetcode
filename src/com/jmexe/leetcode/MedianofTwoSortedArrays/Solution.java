package com.jmexe.leetcode.MedianofTwoSortedArrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Jmexe on 12/6/15.
 * Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * level -- hard
 */
public class Solution {
    static class Median {
        Queue<Integer> left;
        Queue<Integer> right;
        double median;
        int size;

        Median() {
            Comparator<Integer> lcomp = new Comparator<Integer>() {
                public int compare(Integer n1, Integer n2) {
                    return n2 - n1;
                }
            };

            Comparator<Integer> rcomp = new Comparator<Integer>() {
                public int compare(Integer n1, Integer n2) {
                    return n1 - n2;
                }
            };

            left = new PriorityQueue<Integer>(lcomp);
            right = new PriorityQueue<Integer>(rcomp);
            size = 0;
        }

        double add(int e) {
            if (size == 0) {
                median = e;
                size++;
                return median;
            }

            if (size == left.size() + right.size()) {
                if (e == median) {
                    median = e;
                }
                else if (e < median) {
                    left.offer(e);
                    median = left.poll();
                }
                else {
                    right.offer(e);
                    median = right.poll();
                }

            }
            else {
                if (e <= median) {
                    left.offer(e);
                    right.offer((int) median);
                }
                else {
                    left.offer((int) median);
                    right.offer(e);
                }

                median = (double) (left.peek() + right.peek()) / 2;
            }


            size++;
            return median;
        }

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = -1;
        Median medianFinder = new Median();

        for (int n1 : nums1) {
            median = medianFinder.add(n1);
        }

        for (int n2 : nums2) {
            median = medianFinder.add(n2);
        }

        return median;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1, 2, 3, 4}));
    }

}
