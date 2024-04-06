package com.codedecide.leetcode.tree.bfs;

import com.codedecide.leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author geckostroll
 * @version Solution404.java 2024年04月05日
 */
public class Solution404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    sum += node.left.val;
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        return sum;
    }
}
