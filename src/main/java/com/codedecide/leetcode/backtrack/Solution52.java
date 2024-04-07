package com.codedecide.leetcode.backtrack;

/**
 * N皇后II: https://leetcode.cn/problems/n-queens-ii/description/
 * @author geckostroll
 * @version Solution52.java 2024年04月07日
 */
public class Solution52 {

    private Integer counter;

    public int totalNQueens(int n) {
        if (n == 1) {
            return 1;
        }
        counter = 0;
        // 每一个int表示一个选择
        int[] track = new int[n];
        backtrack(n, track, 0);
        return counter;
    }

    public boolean isValid(int n, int[] track, int row, int pos) {
        int val = 1 << pos;
        for (int i =0; i < row; i++) {
            int checkVal = track[i];
            // 判断同一列
            if (checkVal == val) {
                return false;
            }
            // 判断斜线
            int gap = row - i;
            if (pos - gap >= 0 && val >> gap == checkVal) {
                return false;
            }
            if (pos + gap < n && val << gap == checkVal) {
                return false;
            }
        }
        return true;
    }

    public void backtrack(int n, int[] track, int row) {
        if (row >= n) {
            counter++;
        }
        for (int pos = 0; pos < n; pos++) {
            if (!isValid(n, track, row, pos)) {
                continue;
            }
            track[row] = 1 << pos;
            backtrack(n, track, row + 1);
            track[row] = 0;
        }
    }

}
