package com.codedecide.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后问题：https://leetcode.cn/problems/n-queens/
 *
 * @author geckostroll
 * @version Solution51.java 2024年04月05日
 */
public class Solution51 {

    public static boolean isMatch(int rows, int row, int choice, List<Integer> solutionList) {
        for (int i = 0; i < solutionList.size(); i++) {
            int a = solutionList.get(i);
            // 检查是否在同一个竖线
            if (a == choice) {
                return false;
            }
            // 检查是否在同一条斜线
            int gap = row - i;
            if (Math.abs(a - choice) == gap) {
                return false;
            }
        }
        return true;
    }

    public static List<List<Integer>> solve(int rows, int row, List<List<Integer>> resList) {
        List<List<Integer>> newResList = new ArrayList<>();
        for (List<Integer> solutionList: resList) {
            int[] allChoices = buildAllChoices(rows);
            for (int choice: allChoices) {
                if (isMatch(rows, row, choice, solutionList)) {
                    List<Integer> newSolutionList = new ArrayList<>(solutionList);
                    newSolutionList.add(choice);
                    newResList.add(newSolutionList);
                }
            }
        }
        return newResList;
    }

    public static int[] buildAllChoices(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static List<List<Integer>> solve(int rows) {
        int[] allChoices = buildAllChoices(rows);
        List<List<Integer>> resList = new ArrayList<>();
        for (int a: allChoices) {
            List<Integer> solutionList = new ArrayList<>();
            solutionList.add(a);
            resList.add(solutionList);
        }
        for (int row = 1; row < rows; row++) {
            resList = solve(rows, row, resList);
        }
        return resList;
    }

    private static List<String> translate0(List<Integer> value, int rows) {
        List<String> valueList = new ArrayList<>();
        for (int v : value) {
            char[] chars = new char[rows];
            Arrays.fill(chars, '.');
            chars[v] = 'Q';
            valueList.add(new String(chars));
        }
        return valueList;
    }

    public static List<List<String>> translate(List<List<Integer>> values,int rows) {
        List<List<String>> valueList = new ArrayList<>();
        for (List<Integer> value : values) {
            valueList.add(translate0(value, rows));
        }
        return valueList;
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<Integer>> values = solve(n);
        return translate(values, n);
    }

    public static void main(String[] args) {
        solveNQueens(3);
    }
}
