package com.codedecide.leetcode.tree.bfs;

import com.codedecide.leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的最小深度
 *
 * @author geckostroll
 * @version Solution111.java 2024年04月05日
 */
public class Solution111 {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            level++;
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return level;
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        return level;
    }
}
