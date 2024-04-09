package com.codedecide.leetcode.sort;

/**
 * 正整数和负整数的最大计数
 * @author geckostroll
 * @version Solution2529.java 2024年04月09日
 */
public class Solution2529 {



    public int maximumCount(int[] nums) {
        int left = 0, right = nums.length;
        if (nums[0] > 0 || nums[right - 1] < 0) {
            return nums.length;
        }
        while (left < right) {
            int mid = left + (right -left) /2;
            if (nums[mid] >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] == 0) {
            right = left + 1;
            while (right < nums.length) {
                if (nums[right++] != 0) {
                    break;
                }
            }
            return Math.max(left, nums.length - right);
        } else if (nums[left] < 0){
            return Math.max(left + 1, nums.length - 1 - left);
        } else {
            return Math.max(left, nums.length - left);
        }
    }

}
