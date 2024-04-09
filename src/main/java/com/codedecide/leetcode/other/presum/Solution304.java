package com.codedecide.leetcode.other.presum;

/**
 * @author geckostroll
 * @version Solution304.java 2024年04月07日
 */
public class Solution304 {

    class NumMatrix {

        private int[][] presums;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            presums = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    presums[i + 1][j + 1] = presums[i + 1][j] + presums[i][j + 1] + matrix[i][j] - presums[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return presums[row2 + 1][col2 + 1] + presums[row1][col1]  - presums[row2 + 1][col1] - presums[row1][col2 + 1];
        }
    }
}
