package com.codedecide.leetcode.tree.binarysearch;

import com.codedecide.leetcode.tree.TreeNode;

/**
 * 二叉搜索树中第K小的元素: https://leetcode.cn/problems/kth-smallest-element-in-a-bst
 * @author geckostroll
 * @version Solution230.java 2024年04月09日
 */
public class Solution230 {

    // 记录结果
    int res = 0;
    // 记录元素排名
    int rank = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k, 0);
        return res;
    }

    public void inorder(TreeNode root, int k, int rank) {
        if (root == null) {
            return;
        }
        inorder(root.left, k, rank);
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }
        inorder(root.right, k, rank);
    }
}
