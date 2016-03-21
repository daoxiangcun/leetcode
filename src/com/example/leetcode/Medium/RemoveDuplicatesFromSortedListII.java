package com.example.leetcode.Medium;

import java.util.HashMap;

import com.example.leetcode.LinkedList;
import com.example.leetcode.LinkedList.ListNode;
/**
 * leetcode 82. Medium
 * 82. Remove Duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

   For example,
   Given 1->2->3->3->4->4->5, return 1->2->5.
   Given 1->1->1->2->3, return 2->3.
 *
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesFromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        HashMap<Integer, Integer> valTimesMap = new HashMap<Integer, Integer>();
        ListNode node = head;
        ListNode preNode = head;
        while(node != null) {
            int val = node.val;
            if (valTimesMap.containsKey(val)) {
                int times = valTimesMap.get(val);
                times++;
                valTimesMap.put(val, times);
            } else {
                valTimesMap.put(val, 1);
            }
            node = node.next;
        }
        node = head;
        // 跳过开头的有重复的节点
        while(node != null) {
            int val = node.val;
            int times = valTimesMap.get(val);
            if (times > 1) {
                node = node.next;
            } else {
                break;
            }
        }
        if (node == null) {
            return null;
        } else {
            head = node;
            preNode = node;
            node = node.next;
            while(node != null) {
                int val = node.val;
                int times = valTimesMap.get(val);
                if (times == 1) {
                    preNode.next = node;
                    preNode = node;
                    node = node.next;
                } else {
                    node = node.next;
                }
            }
            preNode.next = null;
            return head;
        }
    }

//    public static ListNode deleteDuplicates(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode p1 = head, p2 = head;
//        int count = 0;
//        while(true) {
//            if (p2 == null || p2.val != p1.val) {
//                if (count > 1) {
//                    // should remove value equals p1.val
//                    p1.next = p2.next;
//                    p1.val = p2.val;
//                    p2 = p1;
//                    count = 1;
//                }
//                p1 = p2;
//            } else {
//                count++;
//            }
//            p2 = p2.next;
//        }
//        return head;
//    }

    public static void main(String[] args) {
        int[] listDatas = new int[]{1,1,2,2,3};
        LinkedList list = new LinkedList();
        list.constructList(listDatas);
        list.output();
        ///ListNode newHead = deleteNode(list.head, n);
        //LinkedList.outputList(newHead);
        ListNode newHead = list.head;
        newHead = deleteDuplicates(newHead);
        if (newHead == null) {
            System.out.println("null");
        } else {
            while(newHead != null) {
                System.out.print(newHead.val + " ");
                newHead = newHead.next;
            }
        }
    }
}
