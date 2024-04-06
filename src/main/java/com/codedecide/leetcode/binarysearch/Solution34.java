package com.codedecide.leetcode.binarysearch;

/**
 * 在排序数组中查找元素的第一个和最后一个位置: https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 *
 * @author geckostroll
 * @version Solution34.java 2024年04月06日
 */
public class Solution34 {

    public int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left >= nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int leftBound = leftBound(nums, target);
        if (leftBound == -1) {
            return new int[]{-1, -1};
        } else {
            int i = leftBound + 1;
            while (i < nums.length && nums[i] == target) {
                i++;
            }
            return new int[]{leftBound, i - 1};
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new Solution34().searchRange(nums, 1));
    }
}
