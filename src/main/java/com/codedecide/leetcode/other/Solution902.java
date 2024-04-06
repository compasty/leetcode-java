package com.codedecide.leetcode.other;

import java.util.LinkedList;

/**
 * @author geckostroll
 * @version Solution902.java 2024年04月06日
 */
public class Solution902 {

    public int[] convertToDigits(int n) {
        LinkedList<Integer> digitList = new LinkedList<>();
        while (n != 0) {
            digitList.add(n % 10);
            n = n / 10;
        }
        int[] digits = new int[digitList.size()];
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digitList.pollFirst();
        }
        return digits;
    }

    public int sameWidth(String[] digits, int[] numDigits, int start, int[] baseArr) {
//        int cnt = 0;
//        for (int i = 0; i < numDigits.length; i++) {
//            cnt += ;
//            cnt += sameWidth(digits, numDigits, i, baseArr);
//        }
        return 0;
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        int[] numDigits = convertToDigits(n);
        int cnt = 0;
        int[] baseArr = new int[numDigits.length + 1];
        baseArr[0] = 1;
        for (int i = 1; i < numDigits.length; i++) {
            baseArr[i] = baseArr[i - 1] * numDigits.length;
            cnt += baseArr[i];
        }
        cnt += sameWidth(digits, numDigits, 0, baseArr);
        return cnt;
    }

}
