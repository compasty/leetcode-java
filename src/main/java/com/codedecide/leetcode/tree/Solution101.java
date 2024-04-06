package com.codedecide.leetcode.tree;

/**
 * @author geckostroll
 * @version Solution101.java 2024年04月04日
 */
public class Solution101 {

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null) {
            return right == null;
        }
        if (right == null) {
            return false;
        }
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }
}
