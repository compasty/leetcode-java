package com.codedecide.leetcode.tree;

/**
 * 二叉树的直径
 *
 * @author geckostroll
 * @version Solution543.java 2024年04月05日
 */
public class Solution543 {


    // 返回两个值，一个值是以该节点为终点的直径，一个是不以该节点为终点的最大直径
    public int[] diameter(TreeNode node) {
        int[] zeros = {0, 0};
        if (node == null || (node.left == null && node.right == null)) {
            return zeros;
        }
        int used = 0, notUsed = 0;
        int[] leftArr = (node.left != null) ? diameter(node.left): zeros;
        int[] rightArr = (node.right != null) ? diameter(node.right) : zeros;
        if (node.left != null) {
            used = Math.max(used, leftArr[0] + 1);
            notUsed = Math.max(notUsed, leftArr[1]);
        }
        if (node.right != null) {
            used = Math.max(used, rightArr[0] + 1);
            notUsed = Math.max(notUsed, rightArr[1]);
            if (node.left != null) {
                notUsed = Math.max(notUsed, leftArr[0] + rightArr[0] + 2);
            }
        }
        return new int[]{used, notUsed};
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] arr = diameter(root);
        return Math.max(arr[0], arr[1]);
    }
}
