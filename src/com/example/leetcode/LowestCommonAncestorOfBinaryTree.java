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
        // 在左右子树中找p和q
        if (root == p || root == q) {
            return root;
        }
        // 在左子树中找p或q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 在右子树中找p或q
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
