package com.codedecide.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * N皇后问题：https://leetcode.cn/problems/n-queens/description/
 * @author geckostroll
 * @version Solution51.java 2024年04月06日
 */
public class Solution51 {

    private List<List<String>> resList;

    private Deque<String> track;

    private String[] choices;

    public List<List<String>> solveNQueens(int n) {
        resList = new ArrayList<>();
        track = new LinkedList<>();
        choices = new String[n];
        for (int i = 0; i < n; i++) {
            char[] arr = new char[n];
            Arrays.fill(arr, '.');
            arr[i] = 'Q';
            choices[i] = new String(arr);
        }
        backtrack(n, 0);
        return resList;
    }

    public boolean isValid(int n, int row, int i) {
        int checkRow = 0;
        for (String pre: track) {
            // 判断某一列是否存在皇后
            if (pre.charAt(i) == 'Q') {
                return false;
            }
            // 判断斜线上是否有皇后
            int gap = row - checkRow;
            if (i - gap >= 0 && pre.charAt(i - gap) == 'Q') {
                return false;
            }
            if (i + gap < n && pre.charAt(i + gap) == 'Q') {
                return false;
            }
            checkRow++;
        }

        return true;
    }

    public void backtrack(int n, int row) {
        if (track.size() == n) {
            resList.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(n, row, i)) {
                continue;
            }
            track.addLast(choices[i]);
            backtrack(n, row + 1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution51().solveNQueens(3));
    }
}
