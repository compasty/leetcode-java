package com.codedecide.leetcode.tree;

/**
 * 前序遍历构造二叉搜索树：https://leetcode.cn/problems/construct-binary-search-tree-from-preorder-traversal/description/
 *
 * @author geckostroll
 * @version Solution1008.java 2024年04月06日
 */
public class Solution1008 {

    public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start >= end) {
            return null;
        }
        int rootVal = preorder[start];
        TreeNode root = new TreeNode(rootVal);
        int i = start + 1;
        while (i < preorder.length) {
            if (preorder[i] > rootVal) {
                break;
            }
            i++;
        }
        TreeNode left = bstFromPreorder(preorder, start + 1, i);
        TreeNode right = bstFromPreorder(preorder, i, end);
        root.left = left;
        root.right = right;
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        // 左闭右开
        return bstFromPreorder(preorder, 0, preorder.length);
    }
}
