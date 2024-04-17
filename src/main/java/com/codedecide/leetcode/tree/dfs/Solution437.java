package com.codedecide.leetcode.tree.dfs;

import com.codedecide.leetcode.tree.TreeNode;
import com.codedecide.leetcode.util.TreeNodeUtils;
import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.Map;

/**
 * 路径总和III: https://leetcode.cn/problems/path-sum-iii/description/
 *
 * @author geckostroll
 * @version Solution437.java 2024年04月07日
 */
public class Solution437 {

    private int matchNum;

    public int pathSum(TreeNode root, int targetSum) {
        matchNum = 0;
        // key为前缀和，value为次数
        Map<Long, Integer> presumMap = new HashMap<>();
        // 保证以根节点开头的可以正常匹配
        presumMap.put(0L, 1);
        long curSum = 0;
        dfs(root, targetSum, presumMap, curSum);
        return matchNum;
    }

    public void dfs(TreeNode root, int targetSum, Map<Long, Integer> presumMap, long curSum) {
        if (root == null) {
            return;
        }
        curSum += root.val;
        matchNum += presumMap.getOrDefault(curSum - targetSum, 0);
        presumMap.put(curSum, presumMap.getOrDefault(curSum, 0) + 1);
        dfs(root.left, targetSum, presumMap, curSum);
        dfs(root.right, targetSum, presumMap, curSum);
        presumMap.put(curSum, presumMap.getOrDefault(curSum, 0) - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildFromIntList(Lists.newArrayList(5,4,8,11,null,13,4,7,2,null,null,5,1));
        // 3
        System.out.println(new Solution437().pathSum(root, 22));
    }
}
