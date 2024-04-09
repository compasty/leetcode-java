package com.codedecide.leetcode.dp.stock;

/**
 * 买卖股票的最佳时机II：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 * @author geckostroll
 * @version Solution122.java 2024年04月08日
 */
public class Solution122 {

    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                int temp = prices[i] - prices[i - 1];
                sum += temp;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new Solution122().maxProfit(prices));
    }


}
