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

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public List<List<Integer>> dfs(TreeNode node, int targetSum, List<List<Integer>> resultList) {
        // TODO
        return null;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> resList = new LinkedList<>();
        dfs(root, targetSum, resList);
        return resList;
    }
}
