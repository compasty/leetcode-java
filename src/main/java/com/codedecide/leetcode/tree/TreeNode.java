package com.codedecide.leetcode;

/**
 * @author geckostroll
 * @version TreeNode.java 2024年04月04日
 */
 public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }