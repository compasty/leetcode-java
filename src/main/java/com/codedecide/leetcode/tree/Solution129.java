package com.codedecide.leetcode.tree;

import javax.swing.tree.TreeCellRenderer;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author geckostroll
 * @version Solution129.java 2024年04月04日
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
