package com.codedecide.leetcode.other;

import java.util.ArrayList;
import java.util.List;

/**
 * @author geckostroll
 * @version Solution118.java 2024年04月05日
 */
public class Solution118 {

    public void genNRow(int num, List<List<Integer>> previous) {
        if (num == 1) {
            List<Integer> nList = new ArrayList<>();
            nList.add(1);
            previous.add(nList);
        } else {
            List<Integer> prevRow = previous.get(num - 2);
            List<Integer> curRow = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                int leftValue = (i >= 1 ? prevRow.get(i - 1) : 0);
                int rightValue = (i < prevRow.size() ? prevRow.get(i) : 0);
                curRow.add(leftValue + rightValue);
            }
            previous.add(curRow);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            genNRow(i, res);
        }
        return res;
    }
}
