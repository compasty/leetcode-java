package com.codedecide.leetcode.tree.dfs;

import com.codedecide.leetcode.tree.TreeNode;

/**
 * @author geckostroll
 * @version Solution112.java 2024年04月06日
 */
public class Solution112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        int nextSum = targetSum - root.val;
        if (root.left != null && hasPathSum(root.left, nextSum)) {
            return true;
        }
        if (root.right != null && hasPathSum(root.right, nextSum)) {
            return true;
        }
        return false;
    }
}
