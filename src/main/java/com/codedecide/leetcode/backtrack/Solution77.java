package com.codedecide.leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 组合：https://leetcode.cn/problems/combinations/description/
 *
 * @author geckostroll
 * @version Solution77.java 2024年04月06日
 */
public class Solution77 {
    private List<List<Integer>> resList;

    public List<List<Integer>> combine(int n, int k) {
        resList = new LinkedList<>();
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(n, k, track, 1);
        return resList;
    }

    void backtrack(int n, int k, LinkedList<Integer> track, int start) {
        if (track.size() == k) {
            resList.add(new LinkedList<>(track))
        }
        for (int i = start; i <= n; i++) {
            track.add(i);

        }
    }
}
