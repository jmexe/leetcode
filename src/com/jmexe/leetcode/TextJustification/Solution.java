package com.jmexe.leetcode.TextJustification;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jmexe on 1/12/16.
 * Text Justification
 * https://leetcode.com/problems/text-justification/
 * level - hard
 */
public class Solution {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<String>();

        List<String> lineWords = new ArrayList<String>();
        int words_length = 0;

        for (String word : words) {
            if (words_length + lineWords.size() + word.length() > maxWidth) {
                String line = "";
                int slots = lineWords.size() <= 1 ? 1 : lineWords.size() - 1;
                int spaces = maxWidth - words_length;

                int base = spaces / slots;
                int extra_slots = spaces % slots;

                for (int i = 0; i < lineWords.size(); i++) {
                    line += lineWords.get(i);
                    if (i < slots) {
                        for (int j = 0; j < base; j++) {
                            line += " ";
                        }
                    }

                    if (i < extra_slots) {
                        line += " ";
                    }
                }

                ans.add(line);

                lineWords.clear();
                lineWords.add(word);
                words_length = word.length();

            }
            else {
                lineWords.add(word);
                words_length += word.length();
            }
        }

        if (lineWords.size() > 0) {
            String line = "";
            for (String word : lineWords) {
                line += word + " ";
            }

            line = line.trim();

            int spaces = maxWidth - line.length();
            while (spaces-- > 0) {
                line += " ";
            }
            ans.add(line);
        }

        return ans;
    }


    public static void main(String[] args) {
        String[] words = {"What","must","be","shall","be."};
        List<String> ans = fullJustify(words, 12);
        for (String line : ans) {
            System.out.println(line);
        }
    }
}
