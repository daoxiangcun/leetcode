package com.example.leetcode;

import com.example.leetcode.AddTwoNumber.LinkedList;
import com.example.leetcode.AddTwoNumber.ListNode;

/**
 * 160. Intersection of Two Linked Lists My Submissions Question
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A: a1 → a2
                              ↘
                     c1 → c2 → c3
                             ↗
B: b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 *
 */
public class IntersectionOfTwoLinkedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    static int[] list1Data = new int[]{9, 8};
    static int[] list2Data = new int[]{1};
    static int[] commonData = new int[]{3,4,5};

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.constructList(list1Data);
        outputList(list1.head);

        LinkedList list2 = new LinkedList();
        list2.constructList(list2Data);
        outputList(list2.head);

        ListNode result = addTwoNumbers(list1.head, list2.head);
        outputList(result);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    }
}
