package com.example.leetcode.Easy;

import com.example.leetcode.LinkedList.ListNode;

/**
 * leetcode 203 Easy
 * Remove Linked List Elements
 * Remove all elements from a linked list of integers that have value val.
   Example
   Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
   Return: 1 --> 2 --> 3 --> 4 --> 5
 *
 */
public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        while(head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p2 != null) {
            if (p2.val == val) {
                p1.next = p2.next;
                p2 = p1.next;
            } else {
                p1 = p2;
                p2 = p2.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] listDatas = new int[]{1,2,6,3,4,5,6};
        LinkedList list = new LinkedList();
        list.constructList(listDatas);
        list.output();
        ListNode newHead = removeElements(list.head, 6);
        LinkedList.outputList(newHead);
    }
}
