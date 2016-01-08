package com.jmexe.leetcode.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jmexe on 1/7/16.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * level-medium
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hash = new HashMap<Character, Integer>();
        int max = 0;
        int cnt = 0;
        int lo = 0;
        int hi = 0;

        while (lo < s.length()) {
            while (hi < s.length()) {
                char c = s.charAt(hi);

                if (hash.containsKey(c)) {
                    int newLo = hash.get(c);
                    while (lo <= newLo) {
                        hash.remove(s.charAt(lo));
                        cnt--;
                        lo++;
                    }
                }
                else {
                    hash.put(c, hi);
                    hi++;
                    cnt++;
                    max = Math.max(max, cnt);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcbdace"));
    }

}
