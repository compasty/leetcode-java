package com.codedecide.leetcode.dp;

/**
 * 零钱兑换：https://leetcode.cn/problems/coin-change-ii/description/
 *
 * @author geckostroll
 * @version Solution518.java 2024年04月05日
 */
public class Solution518 {

    public int change(int amount, int[] coins, int n) {
        return 0;
    }

    public int change(int amount, int[] coins) {
        return change(amount, coins, 0);
    }

    public static void main(String[] args) {
        int k = new Solution518().change(5, new int[]{1,2,5});
    }
}
