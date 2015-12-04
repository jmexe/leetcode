package com.jmexe.leetcode.UglyNumber.SuperUglyNumber;

import java.util.Arrays;

/**
 * Created by Jmexe on 12/3/15.
 */
public class Solution {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] ret = new int[n];
        ret[0]    = 1;

        int[] indice  = new int[primes.length];

        for(int i = 1; i < n; i++){
            ret[i] = Integer.MAX_VALUE;

            for(int j = 0; j < primes.length; j++){
                ret[i] = Math.min(ret[i], primes[j] * ret[indice[j]]);
            }

            for(int j = 0; j < indice.length; j++){
                if(ret[i] == primes[j] * ret[indice[j]]){
                    indice[j]++;
                }
            }
        }

        return ret[n - 1];
    }


    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(10, new int[]{2, 3, 5}));
    }
}
