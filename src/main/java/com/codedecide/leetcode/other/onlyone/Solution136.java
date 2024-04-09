package com.codedecide.leetcode.other.onlyone;

/**
 * 只出现一次的数字：https://leetcode.cn/problems/single-number/description/
 *
 * @author geckostroll
 * @version Solution136.java 2024年04月08日
 */
public class Solution136 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res ^= num;
        }
        return res;
    }
}
