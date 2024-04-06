package com.codedecide.leetcode.tree.dfs;

import com.codedecide.leetcode.tree.TreeNode;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

/**
 * @author geckostroll
 * @version Solution113.java 2024年04月05日
 */
public class Solution113 {

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public List<List<Integer>> dfs(TreeNode node, List<List<Integer>> resultList, int targetSum) {
        int sum = node.val;
        if (node.left != null) {

        }
        if (node.right != null) {

        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> pathList = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();
        return null;
//        dfs(root, resultList, targetSum);
    }
}
