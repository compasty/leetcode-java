package com.codedecide.leetcode.dp;

/**
 * 零钱兑换：https://leetcode.cn/problems/coin-change/description/
 *
 * @author geckostroll
 * @version Solution322.java 2024年04月06日
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = amount + 1;
            for (int coin: coins) {
                if (i > coin && dp[i - coin] != 0) {
                    min = Math.min(min, dp[i - coin] + 1);
                } else if (i == coin) {
                    min = 1;
                }
            }
            dp[i] = min;
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
