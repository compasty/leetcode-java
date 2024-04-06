package com.codedecide.leetcode.dp;

import java.util.Arrays;

/**
 * 下降路径最小和：https://leetcode.cn/problems/minimum-falling-path-sum/
 *
 * @author geckostroll
 * @version Solution931.java 2024年04月06日
 */
public class Solution931 {

    int[][] memo;

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int dp(int[][] matrix, int i, int j) {
        if (i < 0 || i >= memo.length || j < 0 || j >= memo[0].length) {
            return 99999;
        }
        if (i == 0) {
            return matrix[0][j];
        }
        if (memo[i][j] != 99999) {
            return memo[i][j];
        }

        int a = matrix[i][j] + min(dp(matrix, i - 1, j - 1),
                dp(matrix, i - 1, j), dp(matrix, i - 1, j + 1));
        memo[i][j] = a;
        return a;
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        memo = new int[n][n];
        for (int i = 0;i < n;i++) {
            Arrays.fill(memo[i], 99999);
        }
        int res = 99999;
        for (int i = 0;i < n; i++) {
            res = Math.min(res, dp(matrix, n - 1, i));
        }
        return res;
    }
}
