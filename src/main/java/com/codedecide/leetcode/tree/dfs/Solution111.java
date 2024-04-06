package com.codedecide.leetcode.tree.dfs;

import com.codedecide.leetcode.tree.TreeNode;

/**
 * @author geckostroll
 * @version Solution111.java 2024年04月06日
 */
public class Solution111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = 100000000;
        if (root.left != null) {
            minDepth = Math.min(minDepth, 1 + minDepth(root.left));
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth, 1 + minDepth(root.right));
        }
        return minDepth;
    }
}
