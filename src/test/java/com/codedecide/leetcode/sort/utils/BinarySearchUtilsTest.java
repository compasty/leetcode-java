package com.codedecide.leetcode.sort.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author geckostroll
 * @version BinarySearchUtilsTest.java 2024年04月09日
 */
public class BinarySearchUtilsTest {

    @Test
    public void testBinarySearch() {
        int[] nums = { -2, -1, 0, 0, 0, 0, 1, 1,2,2,3,5,6,6 };
        assertEquals(BinarySearchUtils.binarySearchLower(nums, 0), 2);
        assertEquals(BinarySearchUtils.binarySearchHigher(nums, 0), 5);
        assertEquals(BinarySearchUtils.binarySearchLower(nums, 4), -1);
        assertEquals(BinarySearchUtils.binarySearchLower(nums, 2), 8);
        assertEquals(BinarySearchUtils.binarySearchHigher(nums, 6), 13);
    }
}
