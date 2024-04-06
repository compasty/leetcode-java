package com.codedecide.leetcode.dp;

import java.util.BitSet;

/**
 * @author geckostroll
 * @version Solution204.java 2024年04月05日
 */
public class Solution204 {

    // 筛法
    public static int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int cnt = 0;
        BitSet bitSet = new BitSet(n + 1);
        for (int i = 2; i <= n; i++) {
            if (!bitSet.get(i)) {
                cnt++;
                int mul = i * 2;
                while (mul <= n) {
                    bitSet.set(mul);
                    mul += i;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
