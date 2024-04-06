package com.codedecide.leetcode.flip;

/**
 * 删掉一个元素以后全为 1 的最长子数组
 * https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/description/
 *
 * @author geckostroll
 * @version Solution1493.java 2024年04月06日
 */
public class Solution1493 {

    public int longestSubarray(int[] nums) {
        int nonOneNum = 0, maxLen = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            int num = nums[right];
            right++;

            if (num != 1) {
                nonOneNum++;
            }
            while (left < right && nonOneNum > 1) {
                if (nums[left] != 1) {
                    nonOneNum--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen - 1;
    }
}
