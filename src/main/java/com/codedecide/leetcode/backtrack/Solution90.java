package com.codedecide.leetcode.backtrack;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 子集II: https://leetcode.cn/problems/subsets-ii
 *
 * @author geckostroll
 * @version Solution90.java 2024年04月05日
 */
public class Solution90 {

    List<List<Integer>> res = new LinkedList<>();

    void backtrack(int[] nums, Set<Integer> usedSet, LinkedList<Integer> path) {
        res.add(new LinkedList<>(path));
        for (int num: nums) {
            if (usedSet.contains(num)) {
                continue;
            }
            path.add(num);
            usedSet.add(num);
            backtrack(nums, usedSet, path);
            path.removeLast();
            usedSet.remove(num);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        Set<Integer> usedSet = new HashSet<>();
        backtrack(nums, usedSet, path);
        return res;
    }
}
