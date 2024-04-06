package com.codedecide.leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 子集：https://leetcode.cn/problems/subsets/description/
 *
 * @author geckostroll
 * @version Solution78.java 2024年04月06日
 */
public class Solution78 {

    private List<List<Integer>> resList;

    public List<List<Integer>> subsets(int[] nums) {
        resList = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track, 0);
        return resList;
    }

    void backtrack(int[] nums, LinkedList<Integer> track, int start) {
        resList.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, track, start + 1);
            track.removeLast();
        }
    }
}
