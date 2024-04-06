package com.codedecide.leetcode.sort;

import java.util.LinkedList;

/**
 * @author geckostroll
 * @version Solution977.java 2024年04月05日
 */
public class Solution977 {

    public int[] sortedSquares(int[] nums) {
        LinkedList<Integer> squareList = new LinkedList<>();
        int front = 0, end = nums.length - 1, v1 = nums[front] * nums[front], v2 = nums[end] * nums[end];
        while (front <= end) {
            if (v1 >= v2) {
                squareList.add(v1);
                front++;
                if (front < nums.length) {
                    v1 = nums[front] * nums[front];
                }
            } else {
                squareList.add(v2);
                end--;
                if (end >= 0) {
                    v2 = nums[end] * nums[end];
                }
            }
        }
        int[] squares = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            squares[i] = squareList.pollLast();
        }
        return squares;
    }
}
