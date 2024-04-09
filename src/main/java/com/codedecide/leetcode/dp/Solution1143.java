package com.codedecide.leetcode.dp;

/**
 * 最长公共子序列：https://leetcode.cn/problems/longest-common-subsequence
 *
 * @author geckostroll
 * @version Solution1143.java 2024年04月07日
 */
public class Solution1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int maxVal = 0, m = text1.length(), n = text2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0;i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = 0;
                if (text1.charAt(i) == text2.charAt(j)) {
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
        return maxVal;
    }

}
