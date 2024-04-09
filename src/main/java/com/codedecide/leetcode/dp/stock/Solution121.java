package com.codedecide.leetcode.dp.stock;

/**
 * 买卖股票的最佳时机：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock
 *
 * @author geckostroll
 * @version Solution121.java 2024年04月08日
 */
public class Solution121 {

    public int maxProfit(int[] prices) {
        int minPrice = 10000000, maxProfit = 0;
        for (int price: prices) {
            int profit = price - minPrice;
            maxProfit = Math.max(maxProfit, profit);
            minPrice = Math.min(minPrice, price);
        }
        return maxProfit;
    }
}
