package com.codedecide.leetcode.tree;

/**
 * @author geckostroll
 * @version Solution106.java 2024年04月04日
 */
public class Solution106 {

    public int findIndex(int[] arr, int start, int checkVal) {
        int i = start;
        while (i < arr.length) {
            if (arr[i] == checkVal) {
                return i;
            }
            i++;
        }
        return i;
    }

    public TreeNode buildTree(int[] inorder, int start0, int end0, int[] postorder, int start1, int end1) {
        if (start0 == end0) {
            return new TreeNode(inorder[start0]);
        } else if (start0 > end0) {
            return null;
        } else {
            int rootVal = postorder[end1];
            TreeNode root = new TreeNode();
            int rootIdx = findIndex(inorder, start0, rootVal);
            int leftLen = rootIdx - start0;
            TreeNode left = buildTree(inorder, start0, rootIdx - 1, postorder, start1, start1 + leftLen - 1);
            int rightLen = end1 - rootIdx;
            TreeNode right = buildTree(inorder, rootIdx + 1, rootIdx + rightLen, postorder, end1 - rightLen, end1 - 1);
            if (left != null) {
                root.left = left;
            }
            if (right != null) {
                root.right = right;
            }
            return root;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
}
