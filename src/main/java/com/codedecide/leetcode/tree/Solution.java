package com.codedecide.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @author geckostroll
 * @version Solution.java 2024年04月04日
 */
class Solution {
    public List<List<Integer>> decorateRecord(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }
        List<List<Integer>> content = new ArrayList<>();
        boolean left = true;
        while (!q.isEmpty()) {
            List<Integer> rowList = new ArrayList<>();
            LinkedList<TreeNode> nextLevel = new LinkedList<>();
            TreeNode node = q.pollLast();
            while (node != null) {
                rowList.add(node.val);
                if (left) {
                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.add(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.add(node.left);
                    }
                }
                node = q.pollLast();
            }
            left = !left;
            q = nextLevel;
            content.add(rowList);
        }
        return content;
    }
}
