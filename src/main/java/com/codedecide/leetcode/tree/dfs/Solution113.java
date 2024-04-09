package com.codedecide.leetcode.tree.dfs;

import com.codedecide.leetcode.tree.TreeNode;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径总和II: https://leetcode.cn/problems/path-sum-ii/description/
 *
 * @author geckostroll
 * @version Solution113.java 2024年04月05日
 */
public class Solution113 {

    private List<List<Integer>> resList;

    private LinkedList<Integer> track;

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public void dfs(TreeNode node, int targetSum, Integer prevSum) {
        if (isLeaf(node)) {
            if (prevSum + node.val == targetSum) {
                track.add(node.val);
                resList.add(new LinkedList<>(track));
            }
            return;
        }
        track.add(node.val);
        if (node.left != null) {
            prevSum += node.val;
            dfs(node.left, targetSum, prevSum);
            prevSum -= node.val;
            track.removeLast();
        }
        if (node.right != null) {
            track.add(node.val);
            prevSum += node.val;
            dfs(node.right, targetSum, prevSum);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return null;
        }
        int prevSum = 0;
        resList = new LinkedList<>();
        track = new LinkedList<>();
        dfs(root, targetSum, prevSum);
        return resList;
    }
}
