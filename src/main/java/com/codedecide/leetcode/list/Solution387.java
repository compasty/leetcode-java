package com.codedecide.leetcode.list;

/**
 * 字符串中的第一个唯一字符：https://leetcode.cn/problems/first-unique-character-in-a-string
 * @author geckostroll
 * @version Solution387.java 2024年04月07日
 */
public class Solution387 {

    public int firstUniqChar(String s) {
        int[] charIdx = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c= s.charAt(i);
            int idx = c - 'a';
            int j = charIdx[idx];
            if (j > 0) {
                charIdx[idx] = -1;
            } else if (j == 0) {
                charIdx[idx] = i + 1;
            }
        }
        int minIdx = s.length();
        for (int i = 0; i < 26; i++) {
            int j = charIdx[i];
            if (j > 0 && j < minIdx) {
                minIdx = j;
            }
        }
        return minIdx == s.length() ? -1 : (minIdx - 1);
    }
}
