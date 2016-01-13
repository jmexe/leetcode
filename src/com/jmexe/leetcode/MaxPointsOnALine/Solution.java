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
        if (points.length < 2) {
            return points.length;
        }

        Map<Float, Set<Point>> hash = new HashMap<Float, Set<Point>>();
        Map<Integer, Set<Point>> hHash = new HashMap<Integer, Set<Point>>();
        Map<Integer, Set<Point>> vHash = new HashMap<Integer, Set<Point>>();
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Point p1 = points[i];
                Point p2 = points[j];

                if (p1.x == p2.x) {
                    if (!vHash.containsKey(p1.x)) {
                        vHash.put(p1.x, new HashSet<Point>());
                    }

                    Set<Point> p1Set = vHash.get(p1.x);
                    p1Set.add(p1);
                    p1Set.add(p2);

                    max = Math.max(max, p1Set.size());
                }
                else if (p1.y == p2.y) {
                    if (!hHash.containsKey(p1.y)) {
                        hHash.put(p1.y, new HashSet<Point>());
                    }

                    Set<Point> p1Set = hHash.get(p1.y);
                    p1Set.add(p1);
                    p1Set.add(p2);

                    max = Math.max(max, p1Set.size());
                }
                else {
                    float angle = (p2.y - p1.y) / (float)(p2.x - p1.x);
                    if (!hash.containsKey(angle)) {
                        hash.put(angle, new HashSet<Point>());
                    }

                    Set<Point> p1Set = hash.get(angle);
                    p1Set.add(p1);
                    p1Set.add(p2);

                    max = Math.max(max, p1Set.size());
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] pointsVals = {{0,-12},{5,2},{2,5},{0,-5},{1,5},{2,-2},{5,-4},{3,4},{-2,4},{-1,4},{0,-5},{0,-8},{-2,-1},{0,-11},{0,-9}};
        Point[] points = new Point[pointsVals.length];
        for (int i = 0; i < pointsVals.length; i++) {
            points[i] = new Point(pointsVals[i][0], pointsVals[i][1]);
        }

        System.out.println(maxPoints(points));
    }
}
