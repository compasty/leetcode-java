package com.codedecide.leetcode.dp;

/**
 * 最长递增子序列: https://leetcode.cn/problems/longest-increasing-subsequence/description/
 *
 *
 * @author geckostroll
 * @version Solution300_2.java 2024年04月06日
 */
public class Solution300_2 {

    // 参考：https://labuladong.online/algo/dynamic-programming/longest-increasing-subsequence/
    public int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        int pileNum = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int left = 0, right = pileNum;

            // 搜索左侧边界的二分查找
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] >= num) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left == pileNum) {
                pileNum++;
            }
            top[left] = num;
        }
        return pileNum;
    }
}
