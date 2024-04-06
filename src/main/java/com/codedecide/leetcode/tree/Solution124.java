package com.codedecide.leetcode.tree;

/**
 * @author geckostroll
 * @version Solution124.java 2024年04月04日
 */
public class Solution124 {

    // 返回两个值，以root为端点的最值和不以root为端点的最值和最大的最值
    public int[] maxPathSum0(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0, 0};
        }
        int[] leftValues = maxPathSum0(root.left);
        int[] rightValues = maxPathSum0(root.right);
        int useRoot = Math.max(leftValues[0] + root.val, rightValues[0] + root.val);
        useRoot = Math.max(useRoot, root.val);
        int notUseRoot = leftValues[0] + root.val + rightValues[0];
        if (root.left != null) {
            notUseRoot = Math.max(notUseRoot, leftValues[2]);
        }
        if (root.right != null) {
            notUseRoot = Math.max(notUseRoot, rightValues[2]);
        }
        return new int[]{useRoot, notUseRoot, Math.max(useRoot, notUseRoot)};
    }

    public int maxPathSum(TreeNode root) {
        int[] vals = maxPathSum0(root);
        return vals[2];
    }


}
