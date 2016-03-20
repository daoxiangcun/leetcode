package com.example.leetcode.Easy;

import com.example.leetcode.LinkedList.ListNode;

/**
 * leetcode 19, Easy
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 *
 */

public class RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int listLen = getLength(head);
        if (listLen < n) {
            return null;
        }
        if (listLen == n) {
            head = head.next;
            return head;
        }
        int steps = listLen - n;
        ListNode node = head;
        for(int i = 0; i < steps-1; i++) {
            node = node.next;
        }
        ListNode newNext = node.next;
        if (newNext.next == null) {
            newNext = null;
        } else {
            newNext = newNext.next;
        }
        node.next = newNext;
        return head;
    }

    public static int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode node = head;
        int len = 0;
        while(node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] listDatas = new int[]{1,2,3,4,5};
        int n = 2;
        LinkedList list = new LinkedList();
        list.constructList(listDatas);
        list.output();
        ListNode newHead = removeNthFromEnd(list.head, n);
        LinkedList.outputList(newHead);
    }
}
