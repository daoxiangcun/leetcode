package com.example.leetcode;

public class LinkedList {
    public ListNode head;

    public LinkedList(){
        head = null;
    }

    public void constructList(int[] datas) {
        if (datas == null || datas.length == 0) {
            return;
        }
        ListNode parent = null;
        ListNode node = null;
        for (int i = 0; i < datas.length; i++) {
            node = new ListNode(datas[i]);
            if (head == null) {
                head = node;
                parent = head;
            } else {
                parent.next = node;
                parent = node;
            }
        }
    }

    public void output() {
        ListNode list = head;
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.print("\n");
    }

    public static void outputList(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.print("\n");
    }

    public int getLength() {
        if (head == null) {
            return 0;
        }
        ListNode node = this.head;
        int len = 0;
        while(node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}