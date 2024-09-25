package com.codedecide.leetcode.binarysearch;

/**
 * 在排序数组中查找元素的第一个和最后一个位置: https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * @author geckostroll
 * @version Solution34.java 2024年04月06日
 */
public class Solution34 {

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) /2;
            if (nums[mid] > target || (lower && nums[mid] == target)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx >= 0 && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new Solution34().searchRange(nums, 1));
    }
}
