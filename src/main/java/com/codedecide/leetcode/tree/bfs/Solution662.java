package com.codedecide.leetcode.tree.bfs;

import com.codedecide.leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author geckostroll
 * @version Solution662.java 2024年04月05日
 */
public class Solution662 {

    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        Deque<Integer> orderQueue = new LinkedList<>();
        q.offer(root);
        orderQueue.offer(0);
        int maxWidth = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            int min = 0, max = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode n = q.poll();
                int order = orderQueue.poll();
                if (i == 0) {
                    min = order;
                }
                if (i == sz - 1) {
                    max = order;
                }
                if (n.left != null) {
                    q.addLast(n.left);
                    orderQueue.addLast(2 * order + 1);
                }
                if (n.right != null) {
                    q.addLast(n.right);
                    orderQueue.addLast(2 * order + 2);
                }
            }
            maxWidth = Math.max(maxWidth, max - min + 1);
        }
        return maxWidth;
    }
}
