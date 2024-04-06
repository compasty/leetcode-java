package com.codedecide.leetcode.tree;


import java.util.LinkedList;
import java.util.List;

/**
 * N叉树的前序遍历：https://leetcode.cn/problems/n-ary-tree-preorder-traversal/description/
 *
 * @author geckostroll
 * @version Solution589.java 2024年04月06日
 */
public class Solution589 {

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public void traverse(Node n, List<Integer> valList) {
        if (n == null) {
            return;
        }
        valList.add(n.val);
        for (Node child: n.children) {
            traverse(child, valList);
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> valList = new LinkedList();
        traverse(root, valList);
        return valList;
    }

}
