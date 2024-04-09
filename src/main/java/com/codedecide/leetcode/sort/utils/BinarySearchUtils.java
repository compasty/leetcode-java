package com.codedecide.leetcode.sort.utils;

/**
 * @author geckostroll
 * @version BinarySearchUtils.java 2024年04月09日
 */
public class BinarySearchUtils {

    /**
     * 寻找给定元素的下标，返回对应的
     * @param nums 非递减数组，允许元素重复
     * @param target 对应目标
     */
    public static int binarySearchLower(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    public static int binarySearchHigher(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right - 1] == target ? right - 1 : -1;
    }
}
