package com.codedecide.leetcode.dp;

/**
 * 两个字符串的删除操作：https://leetcode.cn/problems/delete-operation-for-two-strings/
 *
 * @author geckostroll
 * @version Solution583.java 2024年04月08日
 */
public class Solution583 {

    public int minDistance(String word1, String word2) {
        int maxVal = 0, m = word1.length(), n = word2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0;i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = 0;
                if (word1.charAt(i) == word2.charAt(j)) {
                    val = memo[i][j] + 1;
                } else {
                    val = Math.max(memo[i][j + 1], memo[i + 1][j]);
                }
                memo[i + 1][j + 1] = val;
                if (val > maxVal) {
                    maxVal = val;
                }
            }
        }
        return m + n - 2 * maxVal;
    }
}
