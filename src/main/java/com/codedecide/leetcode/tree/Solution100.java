package com.codedecide.leetcode.tree;

/**
 * 相同的树：https://leetcode.cn/problems/same-tree/description/
 *
 * @author geckostroll
 * @version Solution100.java 2024年04月06日
 */
public class Solution100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        if (q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
