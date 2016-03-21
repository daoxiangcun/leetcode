package com.example.leetcode.Medium;

import com.example.leetcode.LinkedList;
import com.example.leetcode.LinkedList.ListNode;

/**
 * leetcode 143. Medium
 * 143. Reorder List
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
   reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

   You must do this in-place without altering the nodes' values.

   For example,
   Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
    public static ListNode reverseList(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = p1;
        ListNode p3 = p2.next;
        p2.next = null;
        while(p3 != null) {
            p2 = p3;
            p3 = p3.next;
            p2.next = p1;
            p1 = p2;
        }
        return p1;
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        // first, find the middle of the list
        ListNode p1 = head, p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        // now p1.next point to the middle of the list
        ListNode head1 = head;
        ListNode head2 = p1.next;
        p1.next = null;
        head2 = reverseList(head2);

        // merge two list(head1, head2)
        while(head1 != null && head2 != null) {
            ListNode node1 = head1.next;
            ListNode node2 = head2.next;
            head1.next = head2;
            head2.next = node1;
            head1 = node1;
            head2 = node2;
        }
    }

    public static void main(String[] args) {
        int[] listDatas = new int[]{1,2,3,4,5};
        LinkedList list = new LinkedList();
        list.constructList(listDatas);
        list.output();
        reorderList(list.head);
        list.output();
    }
}
