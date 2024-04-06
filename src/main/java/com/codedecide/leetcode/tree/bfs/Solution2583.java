package com.codedecide.leetcode.tree.bfs;

import com.codedecide.leetcode.tree.TreeNode;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author geckostroll
 * @version Solution2583.java 2024年04月05日
 */
public class Solution2583 {

    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Integer> levelQueue = new PriorityQueue<>(k, Comparator.reverseOrder());
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int sz = queue.size();
            int levelSum = 0;
            for (int i = 0; i < sz; i++) {
                TreeNode n = queue.poll();
                levelSum += n.val;
                if (n.left != null) {
                    queue.addLast(n.left);
                }
                if (n.right != null) {
                    queue.addLast(n.right);
                }
            }
            levelQueue.offer(levelSum);
        }
        Integer a = -1;
        for (int i = 0; i < k; i++) {
            a = levelQueue.poll();
            if (a == null) {
                return -1;
            }
        }
        return a;
    }
}
