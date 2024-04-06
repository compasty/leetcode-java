package com.codedecide.leetcode.tree;

/**
 * @author geckostroll
 * @version Solution114.java 2024年04月04日
 */
public class Solution114 {

    public TreeNode flatten0(TreeNode head) {
        if (head == null) {
            return null;
        }
        if (head.left == null && head.right == null) {
            return head;
        }
        TreeNode leftTail = flatten0(head.left);
        TreeNode rightTail = flatten0(head.right);
        head.left = null;
        head.right = head.left;
        if (leftTail != null) {
            leftTail.left = null;
            leftTail.right =  head.right;
        }
        return rightTail;
    }

    public void flatten(TreeNode root) {
        flatten0(root);
    }
}
