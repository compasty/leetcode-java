package com.codedecide.leetcode.tree;

/**
 * 平衡二叉树: https://leetcode.cn/problems/balanced-binary-tree/description/
 *
 * @author geckostroll
 * @version Solution110.java 2024年04月06日
 */
public class Solution110 {
    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }
}
