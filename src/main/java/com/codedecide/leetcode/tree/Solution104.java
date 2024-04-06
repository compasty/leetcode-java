package com.codedecide.leetcode.tree;

/**
 * 二叉树的最大深度
 *
 * @author geckostroll
 * @version Solution104.java 2024年04月06日
 */
public class Solution104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
