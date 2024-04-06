package com.codedecide.leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列： https://leetcode.cn/problems/permutations/description/
 * @author geckostroll
 * @version Solution46.java 2024年04月06日
 */
public class Solution46 {

    private List<List<Integer>> resList;

    public List<List<Integer>> permute(int[] nums) {
        resList = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, track, used);
        return resList;
    }

    public void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        if (track.size() == nums.length) {
            resList.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            int num = nums[i];
            track.add(num);
            used[i] = true;
            backtrack(nums, track, used);
            track.removeLast();
            used[i] = false;
        }
    }
}
