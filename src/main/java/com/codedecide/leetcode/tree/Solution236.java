package com.codedecide.leetcode.tree;

/**
 * 二叉树的最近公共祖先：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * @author geckostroll
 * @version Solution236.java 2024年04月06日
 */
public class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.left, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
