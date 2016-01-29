package com.jmexe.interview.SudokuVerifier;

import java.util.Scanner;

/**
 * Created by Jmexe on 1/25/16.
 */
public class Solution {
    public static int solver(String read) {
        for (int i = 0; i < 9; i++) {
            boolean[] rows = new boolean[9];
            boolean[] cols = new boolean[9];
            boolean[] block = new boolean[9];

            for (int j = 0; j < 9; j++) {
                if (rows[read.charAt(j * 9 + i) - '1'] || cols[read.charAt(i * 9 + j) - '1'] || block[read.charAt(((i / 3) * 3 + j / 3) * 9 + ((i % 3) * 3 + j % 3)) - '1']) {
                    return 0;
                }
                rows[read.charAt(j * 9 + i) - '1'] = true;
                cols[read.charAt(i * 9 + j) - '1'] = true;
                block[read.charAt(((i / 3) * 3 + j / 3) * 9 + ((i % 3) * 3 + j % 3)) - '1'] = true;
            }
        }
        return 1;
    }
    //Test case : 417369825632158947958724316825437169791586432346912758289643571573291684164875293
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String read = in.next();
        System.out.println(solver(read));
    }
}
