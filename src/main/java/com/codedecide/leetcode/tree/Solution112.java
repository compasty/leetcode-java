package com.codedecide.leetcode.tree;

/**
 * @author geckostroll
 * @version Solution112.java 2024年04月05日
 */
public class Solution112 {

    public boolean dfs(TreeNode node, int target) {
        // TODO
        return false;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum);
    }
}
