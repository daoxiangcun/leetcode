package com.example.leetcode;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int value) {
            val = value;
            next = null;
        }
    }

    public static class List{
        public ListNode head;
        public void constructList(int[] datas) {
            if(datas != null && datas.length > 0) {
                ListNode parent = head;
                for(int i = 0; i < datas.length; i++) {
                    int value = datas[i];
                    ListNode node = new ListNode(value);
                    if (head == null) {
                        head = node;
                        parent = node;
                    } else {
                        parent.next = node;
                        parent = node;
                    }
                }
            }
        }
    }

    public static void output(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.print("\n");
    }

    public static int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int len = 0;
        while(head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode list = null;
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            list = l1;
            l1 = l1.next;
        } else {
            list = l2;
            l2 = l2.next;
        }
        ListNode returnList = list;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                list.next = l1;
                l1 = l1.next;
            } else {
                list.next = l2;
                l2 = l2.next;
            }
            list = list.next;
        }
        while (l1 != null) {
            list.next = l1;
            l1 = l1.next;
            list = list.next;
        }
        while (l2 != null) {
            list.next = l2;
            l2 = l2.next;
            list = list.next;
        }
        return returnList;
    }
}
