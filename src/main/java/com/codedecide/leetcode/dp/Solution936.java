package com.codedecide.leetcode.dp;

/**
 * 戳印序列: https://leetcode.cn/problems/stamping-the-sequence
 *
 * @author geckostroll
 * @version Solution936.java 2024年04月07日
 */
public class Solution936 {

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            memo[i + 1][0] = memo[i][0] + s1.charAt(i);
        }
        for (int j = 0; j < n; j++) {
            memo[0][j + 1] = memo[0][j] + s2.charAt(j);
        }
        for (int i = 0;i < m; i++) {
            for (int j = 0; j < n; j++) {
                int c1 = s1.charAt(i);
                int c2 = s2.charAt(j);
                if (c1 == c2) {
                    memo[i + 1][j + 1] = memo[i][j];
                } else {
                    memo[i + 1][j + 1] = Math.min(memo[i][j + 1] + c1, memo[i + 1][j] + c2);
                }
            }
        }
        return memo[m][n];
    }

}
