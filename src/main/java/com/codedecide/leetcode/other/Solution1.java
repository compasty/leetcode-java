package com.codedecide.leetcode.other;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和：https://leetcode.cn/problems/two-sum/
 * @author geckostroll
 * @version Solution1.java 2024年04月08日
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer v = targetMap.get(nums[i]);
            if (v == null) {
                targetMap.put(target - nums[i], i);
            } else {
                return new int[]{i, v};
            }
        }
        return null;
    }

}
