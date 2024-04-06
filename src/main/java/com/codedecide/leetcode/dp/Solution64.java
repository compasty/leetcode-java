package com.codedecide.leetcode.dp;

/**
 * 最小路径和：https://leetcode.cn/problems/minimum-path-sum/description/
 *
 * @author geckostroll
 * @version Solution64.java 2024年04月04日
 */
public class Solution64 {

    public int minPathSum(int[][] grid) {
        int len = grid.length;
        int[][] dp = new int[len][];
        for (int i = 0; i < len; i++) {
            dp[i] = new int[grid[i].length];
        }
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[len - 1][grid[len - 1].length - 1];
    }
}
