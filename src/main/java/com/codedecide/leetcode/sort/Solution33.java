package com.codedecide.leetcode.sort;

/**
 * 搜索旋转排序数组：https://leetcode.cn/problems/search-in-rotated-sorted-array/description/
 * @author geckostroll
 * @version Solution33.java 2024年04月11日
 */
public class Solution33 {

    public int search(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (mid == start) {
            return -1;
        }
        if (nums[mid] > nums[start]) {
            // 表示左边是有序的
            if (nums[mid] > target && nums[start] <= target) {
                return search(nums, target, start, mid);
            } else {
                return search(nums, target, mid, end);
            }
        } else {
            // 表示右侧是有序的
            if (nums[mid] < target && nums[end - 1] >= target) {
                return search(nums, target, mid, end);
            } else {
                return search(nums, target, start, mid);
            }
        }
    }

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length);
    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 3};
//        System.out.println(new Solution33().search(nums1, 1));
        int[] nums2 = {4,5,6,7,0,1,2};
        System.out.println(new Solution33().search(nums2, 6));
    }

}
