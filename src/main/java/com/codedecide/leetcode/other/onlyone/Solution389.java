package com.codedecide.leetcode.other.onlyone;

/**
 * 找不同：https://leetcode.cn/problems/find-the-difference/
 *
 * @author geckostroll
 * @version Solution389.java 2024年04月08日
 */
public class Solution389 {

    public char findTheDifference(String s, String t) {
        char ret = 0;
        for (char ch: s.toCharArray()) {
            ret ^= ch;
        }
        for (char ch: t.toCharArray()) {
            ret ^= ch;
        }
        return ret;
    }
}
