package com.codedecide.leetcode.dp;

/**
 * @author geckostroll
 * @version Solution279.java 2024年04月05日
 */
public class Solution279 {

    public static int numSquares(int k, int[] dp) {
        if (k == 0) {
            return 0;
        } else if (dp[k] > 0) {
            return dp[k];
        }
        int min = k;
        int m = (int)Math.floor(Math.sqrt(k));
        for (int i = m; i >= 1; i--) {
            int s = numSquares(k - i * i, dp) + 1;
            if (s < min) {
                min = s;
            }
        }
        dp[k] = min;
        return min;
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        return numSquares(n, dp);
    }

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }
}
