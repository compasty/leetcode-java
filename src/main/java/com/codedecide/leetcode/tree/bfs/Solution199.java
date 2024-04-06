package com.codedecide.leetcode.tree.bfs;

import com.codedecide.leetcode.tree.TreeNode;
import com.codedecide.leetcode.util.TreeNodeUtils;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/binary-tree-right-side-view/
 *
 * @author geckostroll
 * @version Solution199.java 2024年04月05日
 */
public class Solution199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> valList = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode n = q.poll();
                if (i == sz - 1) {
                    valList.add(n.val);
                }
                if (n.left != null) {
                    q.addLast(n.left);
                }
                if (n.right != null) {
                    q.addLast(n.right);
                }
            }
        }
        return valList;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildFromIntList(Lists.newArrayList(1, 2, 3, null, 5, null, 4));

        System.out.println(new Solution199().rightSideView(root));
    }

}
