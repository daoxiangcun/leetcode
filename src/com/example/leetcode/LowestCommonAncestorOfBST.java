package com.example.leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonAncestorOfBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // 构建二叉排序树

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p.left == q || p.right == q) {
            return p;
        }
        if (q.left == p || q.right == p) {
            return q;
        }
        if (p == root || q == root) {
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            // 在左子树
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            // 在右子树
            return lowestCommonAncestor(root.right, p, q);
        } else if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
            return root;
        } else {
            return null;
        }
    }
}