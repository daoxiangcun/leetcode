package com.example.leetcode;

public class BinaryTree {
    public static class Node {
        int data;
        Node left;
        Node right;
    }

    public static void middleOrder(Node root) {
        if (root.left != null) {
            middleOrder(root.left);
        }
        System.out.print(root.data + " ");
        if (root.right != null) {
            middleOrder(root.right);
        }
    }

    static int[] datas = new int[]{7,3,5,2,8,6,9,10};

    public static void main(String[] args) {
        Node root = null;
        for (int i = 0; i < datas.length; i++) {
            Node oneNode = new Node();
            oneNode.data = datas[i];
            if (root == null) {
                root = oneNode;
                continue;
            }
            Node tempNode = root;
            while(true) {
                if (oneNode.data == tempNode.data) {
                    break;
                }
                if (oneNode.data < tempNode.data) {
                    if (tempNode.left == null) {
                        tempNode.left = oneNode;
                        break;
                    } else {
                        tempNode = tempNode.left;
                    }
                } else {
                    if (tempNode.right == null) {
                        tempNode.right = oneNode;
                        break;
                    } else {
                        tempNode = tempNode.right;
                    }
                }
            }
        }
        if (root != null) {
            middleOrder(root);
        }
    }
}
