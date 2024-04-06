package com.codedecide.leetcode.dp;


import java.util.ArrayList;
import java.util.List;

/**
 * 全排列：https://leetcode.cn/problems/permutations/description/
 *
 * @author geckostroll
 * @version Solution46.java 2024年04月05日
 */
public class Solution46 {

    public List<Integer> buildNewList(List<Integer> numList, int newNum, int idx) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < numList.size(); i++) {
            if (i == idx) {
                newList.add(numList.get(i));
                newList.add(newNum);
            } else {
                newList.add(numList.get(i));
            }
        }
        return newList;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        numList.add(nums[0]);
        resList.add(numList);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            List<List<Integer>> newResList = new ArrayList<>();
            for (List<Integer> nList: resList) {
                List<Integer> newList = new ArrayList<>();
                newList.add(num);
                newList.addAll(nList);
                newResList.add(newList);
                for (int j = 0; j < i; j++) {
                    newResList.add(buildNewList(nList, num, j));
                }
            }
            resList = newResList;
        }
        return resList;
    }

    public static void main(String[] args) {
        List<List<Integer>> resList = new Solution46().permute(new int[]{1,2,3});
        System.out.println(resList.size());
    }
}
