package com.example.leetcode;

public class LowestCommonAncestorOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // ��������������p��q
        if (root == p || root == q) {
            return root;
        }
        // ������������p��q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // ������������p��q
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }
    }
}
