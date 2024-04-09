package com.codedecide.leetcode.dp;

/**
 * 编辑距离：https://leetcode.cn/problems/edit-distance/description/
 *
 * @author geckostroll
 * @version Solution72.java 2024年04月08日
 */
public class Solution72 {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < m;i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                }

            }
        }
        return dp[m][n];
    }
}
