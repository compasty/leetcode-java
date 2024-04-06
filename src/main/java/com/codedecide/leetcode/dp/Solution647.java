package com.codedecide.leetcode.dp;

/**
 * @author geckostroll
 * @version Solution647.java 2024年04月04日
 */
public class Solution647 {

    public static int countSubstrings(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        if (len == 1) {
            return 1;
        } else if (len == 2) {
            return chars[0] == chars[1] ? 3 : 2;
        }
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            // 1表示是回文, -1表示不是
            dp[i][i] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= i; j++) {
                int flag = dp[i - 1][i - j + 1];
                if (flag == 1) {
                    dp[i][i - j] = (chars[i] == chars[i - j] ? 1 : -1);
                } else {
                    dp[i][i - j] = -1;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }
}
