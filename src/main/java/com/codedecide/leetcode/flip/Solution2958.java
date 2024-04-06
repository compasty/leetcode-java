package com.codedecide.leetcode.flip;

import java.util.HashMap;
import java.util.Map;

/**
 * 最多 K 个重复元素的最长子数组: https://leetcode.cn/problems/length-of-longest-subarray-with-at-most-k-frequency/
 *
 * @author geckostroll
 * @version Solution2958.java 2024年04月06日
 */
public class Solution2958 {

    public int maxSubarrayLength(int[] nums, int k) {
        int left = 0, right = 0;
        Map<Integer, Integer> window = new HashMap<>();
        int res = 0;
        int unvalid = 0;
        while (right < nums.length) {
            int num = nums[right];
            int counter = window.getOrDefault(num, 0) + 1;
            if (counter == k + 1) {
                unvalid++;
            }
            window.put(num, counter);
            right++;

            while (unvalid > 0) {
                int num2 = nums[left];
                int counter2 = window.get(num2) - 1;
                if (counter2 == k) {
                    unvalid--;
                }
                window.put(num2, counter2);
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

}
