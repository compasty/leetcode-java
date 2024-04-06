package com.codedecide.leetcode.other;

/**
 * @author geckostroll
 * @version Solution2697.java 2024年04月04日
 */
public class Solution2697 {

    public String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int front = 0, end = s.length() - 1;
        while (front < end) {
            if (arr[front] > arr[end]) {
                arr[front] = arr[end];
            } else if (arr[front] < arr[end]) {
                arr[end] = arr[front];
            }
            front++;
            end--;
        }
        return new String(arr);
    }
}
