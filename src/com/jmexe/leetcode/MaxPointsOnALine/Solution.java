package com.jmexe.leetcode.MaxPointsOnALine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jmexe on 1/12/16.
 */

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class Solution {
    public static int maxPoints(Point[] points) {
        int max = 0;

        for (int i = 0; i < points.length; i++) {
            Map<Float, Integer> hash = new HashMap<Float, Integer>();
            int same = 1;
            for (int j = i + 1; j < points.length; j++) {
                Point x = points[i];
                Point y = points[j];

                if (x.x == y.x && x.y == y.y) {
                    same++;
                }
                else if (y.x == x.x) {
                    if (!hash.containsKey(Float.MAX_VALUE)) {
                        hash.put(Float.MAX_VALUE, 0);
                    }
                    hash.put(Float.MAX_VALUE, hash.get(Float.MAX_VALUE) + 1);
                }
                else if (y.y == x.y) {
                    if (!hash.containsKey((float)0)) {
                        hash.put((float)0, 0);
                    }
                    hash.put((float)0, hash.get((float)0) + 1);
                }
                else {
                    float slp = (float)(y.y - x.y) / (float)(y.x - x.x);

                    if (!hash.containsKey(slp)) {
                        hash.put(slp, 0);
                    }
                    hash.put(slp, hash.get(slp) + 1);
                }
            }
            int localMax = 0;
            for (int lines : hash.values()) {
                localMax = Math.max(localMax, lines);
            }
            localMax += same;
            max = Math.max(localMax, max);
        }


        return max;
    }

    public static void main(String[] args) {
        //int[][] pointsVals = {{0,-12},{5,2},{2,5},{0,-5},{1,5},{2,-2},{5,-4},{3,4},{-2,4},{-1,4},{0,-5},{0,-8},{-2,-1},{0,-11},{0,-9}};
        int[][] pointsVals = {{2, 3}, {3, 3}, {-5, 3}};
        Point[] points = new Point[pointsVals.length];
        for (int i = 0; i < pointsVals.length; i++) {
            points[i] = new Point(pointsVals[i][0], pointsVals[i][1]);
        }

        System.out.println(maxPoints(points));
    }
}
