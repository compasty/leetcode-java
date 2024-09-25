package com.codedecide.leetcode.binarysearch;

/**
 * 旋转数组搜索
 *
 * @author geckostroll
 * @version Solution33.java 2024年07月16日
 */
public class Solution33 {


    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 表示右半边是有序的
            if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            } else {
                // 表示左半部分是有序的
                if (nums[left] <= target  && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
