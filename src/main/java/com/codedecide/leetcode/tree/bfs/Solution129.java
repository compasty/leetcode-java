package com.codedecide.leetcode.tree.bfs;

import com.codedecide.leetcode.tree.TreeNode;

/**
 *
 * 求根节点到叶节点数字之和：https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 *
 * @author geckostroll
 * @version Solution129.java 2024年04月06日
 */
public class Solution129 {


    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
