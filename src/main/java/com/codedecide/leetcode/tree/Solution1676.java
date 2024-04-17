package com.codedecide.leetcode.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * 二叉树的最近公共祖先IV: https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree-iv/description/
 * @author geckostroll
 * @version Solution1676.java 2024年04月09日
 */
public class Solution1676 {

    Set<TreeNode> set = new HashSet<TreeNode>();

    public TreeNode dfs(TreeNode node) {
        if (set.contains(node)) {
            return node;
        }
        TreeNode leftAncestor = null, rightAncestor = null;
        if (node.left != null) {
            leftAncestor = dfs(node.left);
        }
        if (node.right != null) {
            rightAncestor = dfs(node.right);
        }
        if (leftAncestor != null && rightAncestor != null) {
            return node;
        }
        return leftAncestor != null ? leftAncestor : rightAncestor;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        for (TreeNode node : nodes) {
            set.add(node);
        }
        return dfs(root);
    }
}
