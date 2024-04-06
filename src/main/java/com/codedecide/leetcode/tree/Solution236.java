package com.codedecide.leetcode.tree;

/**
 * 二叉树的最近公共祖先：https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * @author geckostroll
 * @version Solution236.java 2024年04月06日
 */
public class Solution236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        int findNum = 0;
        dfs(root, p, q, cur, findNum);
        return cur;
    }

    public void dfs(TreeNode n, TreeNode p, TreeNode q, TreeNode cur, int findNum) {
        if (cur == p || cur == q) {
            findNum++;
        }
        if (findNum == 2) {

        }
        if (n.left != null) {
            dfs(n.left, p, q, cur, findNum);
        }
        if (n.right != null) {

        }
    }
}
