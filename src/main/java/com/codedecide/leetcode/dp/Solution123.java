package com.codedecide.leetcode.dp;

/**
 * @author geckostroll
 * @version Solution123.java 2024年04月04日
 */
public class Solution123 {

    int findMaxProfit(int[] prices, int[][] dp, int i1, int i2) {
        return 0;
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int len = prices.length;
        int maxProfit = 0;
        // 第一个坐标表示第一笔结束的日期，第二个坐标是第二笔结束的日期
        int[][] dp = new int[len + 1][len + 1];
        for (int i2 = 1; i2 <= len; i2++) {
            for (int i1 = 1; i1 < i2; i1++) {
                dp[i1][i2] = findMaxProfit(prices, dp, i1, i2);
                if (dp[i1][i2] > maxProfit) {
                    maxProfit = dp[i1][i2];
                }
            }
        }
        return maxProfit;
    }

}
