package com.codedecide.leetcode.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 子集II: https://leetcode.cn/problems/subsets-ii
 *
 * @author geckostroll
 * @version Solution90.java 2024年04月05日
 */
public class  Solution90 {

    List<List<Integer>> res = new LinkedList<>();

    LinkedList<Integer> track = new LinkedList<>();

    void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            // 剪枝逻辑，值相同的相邻树枝，只遍历第一条
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            track.addLast(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }
}
