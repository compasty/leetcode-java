package com.codedecide.leetcode.tree.dfs;

import com.codedecide.leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 求根节点到叶节点数字之和：https://leetcode.cn/problems/sum-root-to-leaf-numbers/
 *
 * @author geckostroll
 * @version Solution129.java 2024年04月06日
 */
public class Solution129 {

    public int sumNumbers(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        int sum = 0;
        Deque<Integer> valList = new LinkedList<>();
        q.offer(root);
        valList.offer(root.val);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode n = q.poll();
                int v = valList.poll();
                if (n.left == null && n.right == null) {
                    sum += v;
                } else {
                    if (n.left != null) {
                        q.addLast(n.left);
                        valList.addLast(v * 10 + n.left.val);
                    }
                    if (n.right != null) {
                        q.addLast(n.right);
                        valList.addLast(v * 10 + n.right.val);
                    }
                }
            }
        }
        return sum;
    }
}
