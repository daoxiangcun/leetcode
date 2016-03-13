package com.example.leetcode;

import com.example.leetcode.LinkedList.ListNode;

/**
 * leetcode 237, Easy
 * Delete Node in a Linked List
   Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
   Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function. *
 */
public class DeleteNodeInALinkedList {
    public static void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

    public static void main(String[] args) {
        int[] listDatas = new int[]{1,2,3,4,5};
        LinkedList list = new LinkedList();
        list.constructList(listDatas);
        list.output();
        ///ListNode newHead = deleteNode(list.head, n);
        //LinkedList.outputList(newHead);
        ListNode node = list.head.next.next;
        deleteNode(node);
        list.output();
    }
}
