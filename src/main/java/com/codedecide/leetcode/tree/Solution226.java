package com.codedecide.leetcode.tree;

/**
 * 翻转二叉树：https://leetcode.cn/problems/invert-binary-tree/description/
 * @author geckostroll
 * @version Solution226.java 2024年04月06日
 */
public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
}
