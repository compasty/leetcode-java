package com.codedecide.leetcode.other;

/**
 * @author geckostroll
 * @version Solution123.java 2024年04月04日
 */
public class Solution263 {
    public static boolean isUgly(int n) {
        if (n == 1 || n == 0 || n == -1) {
            return true;
        }
        while (n % 5 == 0) {
            n = n / 5;
            if (n == 1 || n == -1) {
                return true;
            }
        }
        while (n % 3 == 0) {
            n = n / 3;
            if (n == 1 || n == -1) {
                return true;
            }
        }
        while (n % 2 == 0) {
            n = n / 2;
            if (n == 1 || n == -1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(-2147483648));
    }
}
