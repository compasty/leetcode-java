package com.codedecide.leetcode.tree;


/**
 * @author geckostroll
 * @version Solution1026.java 2024年04月05日
 */
public class Solution1026 {

    // 返回节点即其子节点的最大值，最小值和最大差值
    public int[] nodeInfo(TreeNode root) {
        if (root == null) {
            return new int[]{0,0,0};
        } else if (root.left == null && root.right == null) {
            return new int[]{root.val, root.val, 0};
        }
        int[] leftArr  = nodeInfo(root.left);
        int[] rightArr = nodeInfo(root.right);
        return null;
    }

    public int maxAncestorDiff(TreeNode root) {
        return 0;
    }
}
