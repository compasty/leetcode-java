package com.codedecide.leetcode.dp;

import java.util.Arrays;

/**
 * 俄罗斯套娃信封问题: https://leetcode.cn/problems/russian-doll-envelopes/description/
 *
 * @author geckostroll
 * @version Solution354.java 2024年04月06日
 */
public class Solution354 {

    public int lengthOfLIS(int[] nums) {
        // 见前文
        int[] top = new int[nums.length];
        int piles = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] >= num) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left == piles) {
                piles++;
            }
            top[left] = num;
        }
        return piles;
    }

    // 参考：
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (int[] a, int[] b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = envelopes.length;
        // 对高度数组寻找 LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++)
            height[i] = envelopes[i][1];

        return lengthOfLIS(height);
    }
}
