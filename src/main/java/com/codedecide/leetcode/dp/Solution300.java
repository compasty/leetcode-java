package com.codedecide.leetcode.dp;

/**
 * 最长递增子序列: https://leetcode.cn/problems/longest-increasing-subsequence/description/
 *
 * @author geckostroll
 * @version Solution300.java 2024年04月04日
 */
public class Solution300 {


    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 0;
        for (int i = 1; i < nums.length; i++) {
            int v = 1;
            int num = nums[i];
            for (int j = 0; j < i; j++) {
                if (num > nums[j]) {
                    v = Math.max(v, dp[j] + 1);
                }
            }
            dp[i] = v;
            maxLen = Math.max(maxLen, v);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(new Solution300().lengthOfLIS(nums));
    }

}
