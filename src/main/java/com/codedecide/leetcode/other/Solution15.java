package com.codedecide.leetcode.other;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author geckostroll
 * @version Solution15.java 2024年07月14日
 */
public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length < 3) {
            return resultList;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0;i < nums.length - 2;i++) {
            for (int j = i + 1; j < nums.length -1;j++) {
                int left = (-1) * (nums[i] + nums[j]);
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] == left) {
                        List<Integer> oneList = new ArrayList<>();
                        oneList.add(nums[i]);
                        oneList.add(nums[j]);
                        oneList.add(nums[k]);
                        resultList.add(oneList);
                    }
                }
            }
        }
        return resultList;
    }

}
