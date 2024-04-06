package com.codedecide.leetcode.binarysearch;

/**
 * 二分查找：https://leetcode.cn/problems/binary-search/
 * @author geckostroll
 * @version Solution704.java 2024年04月06日
 */
public class Solution704 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

}
