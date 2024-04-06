package com.codedecide.leetcode.util;

import com.codedecide.leetcode.tree.TreeNode;

import java.util.List;

/**
 * @author geckostroll
 * @version TreeNodeUtils.java 2024年04月05日
 */
public class TreeNodeUtils {

    private static TreeNode buildFromIntList(List<Integer> valList, int idx) {
        if (idx >= valList.size()) {
            return null;
        }
        if (valList.get(idx) == null) {
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = valList.get(idx);
        TreeNode leftNode = buildFromIntList(valList, 2 * idx + 1);
        TreeNode rightNode = buildFromIntList(valList, 2 * idx + 2);
        node.left = leftNode;
        node.right = rightNode;
        return node;
    }

    public static TreeNode buildFromIntList(List<Integer> valList) {
        if (valList == null) {
            return null;
        }
        return buildFromIntList(valList, 0);
    }
}
