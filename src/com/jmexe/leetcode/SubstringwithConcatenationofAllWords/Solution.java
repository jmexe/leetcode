package com.jmexe.leetcode.SubstringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jmexe on 12/28/15.
 */
public class Solution {
    public static List<Integer> findSubstring(String s, String[] words) {
        Map<String, Boolean> hash = new HashMap<String, Boolean>();
        for (String word : words) {
            hash.put(word, false);
        }

        int wordL = words[0].length();
        int wordCnt = words.length;
        int len = s.length();
        boolean[] valids = new boolean[len];
        for (int i = 0; i < len; i++) {
            valids[i] = true;
        }
        List<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < len - wordL * wordCnt + 1; i++) {
            int cnt = 0;
            for (int j = i; j < len; j+=wordL) {
                if (j + wordL <= len && hash.containsKey(s.substring(j, j + wordL)) && !hash.get(s.substring(j, j + wordL))) {
                    hash.put(s.substring(j, j + wordL), true);
                    cnt++;

                    if (cnt == wordCnt) {
                        ans.add(i);
                        clean(hash);
                        break;
                    }
                }
                else {
                    clean(hash);
                    break;
                }
            }

        }

        return ans;
    }

    public static void clean(Map<String, Boolean> hash) {
        for (String key : hash.keySet()) {
            hash.put(key, false);
        }
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};

        System.out.println(findSubstring(s, words).toString());
    }

}
