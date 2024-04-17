package com.codedecide.leetcode.tree;

/**
 * 完全二叉树的数目
 *
 * @author geckostroll
 * @version Solution222.java 2024年04月09日
 */
public class Solution222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode leftNode = root, rightNode = root;
        int level = 1, counter = 1, sum = 0;
        while (leftNode.left != null && rightNode.right != null) {
            sum += counter;
            leftNode = leftNode.left;
            rightNode = rightNode.right;
            level++;
            counter = counter << 1;
        }
        // TODO
        return 0;
    }
}
