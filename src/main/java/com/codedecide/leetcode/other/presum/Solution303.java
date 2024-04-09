package com.codedecide.leetcode.other.presum;

/**
 * 区域和检索 - 数组不可变: https://leetcode.cn/problems/range-sum-query-immutable
 *
 * @author geckostroll
 * @version Solution303.java 2024年04月07日
 */
public class Solution303 {

    class NumArray {

        private int[] presums;

        public NumArray(int[] nums) {
            presums = new int[nums.length + 1];
            presums[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                presums[i + 1] = presums[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return presums[right + 1] - presums[left];
        }
    }
}
