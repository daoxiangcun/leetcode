package com.example.leetcode;

/*2. Add Two Numbers My Submissions Question
Total Accepted: 124747 Total Submissions: 557665 Difficulty: Medium
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 . 4 . 3) + (5 . 6 . 4)
Output: 7 . 0 . 8
*/

/**
 * Definition for singly-linked list.
 *  ListNode {
 *     int val;
 *      ListNode *next;
 * };
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class AddTwoNumber {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static class LinkedList {
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
    }

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

    public static ListNode addTwoNumbers111(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

         ListNode reversedL1 = reverseList(l1);
         outputList(reversedL1);
         ListNode reversedL2 = reverseList(l2);
         outputList(reversedL2);
         int addedValue = 0;
         ListNode newHead = null;
         newHead = reversedL1;
        while(reversedL1 != null && reversedL2 != null) {
            int l1Value = reversedL1.val;
            int l2Value = reversedL2.val;
            int total = l1Value + l2Value + addedValue;
            addedValue = total/10;
            reversedL1.val = total >= 10 ? total%10 : total;
            if (addedValue > 0 && reversedL1.next == null) {
                ListNode newNode = new ListNode(addedValue);
                reversedL1.next = newNode;
                reversedL1 = reversedL1.next;
            }
            reversedL1 = reversedL1.next;
            reversedL2 = reversedL2.next;
        }

        if (newHead != null) {
            ////newHead = reverseList(newHead);
            return newHead;
        }
        return null;
    }

    static int[] list1Data = new int[]{9, 8};
    static int[] list2Data = new int[]{1};
//    static int[] list1Data = new int[]{5};
//    static int[] list2Data = new int[]{5};

    public static void outputList(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int addedValue = 0;
        int l1Len = getLength(l1);
        int l2Len = getLength(l2);
        ListNode longerList = l1Len >= l2Len ? l1 : l2;
        ListNode returnListNode = longerList;
        while (l1 != null && l2 != null) {
            int l1Value = l1.val;
            int l2Value = l2.val;
            int total = l1Value + l2Value + addedValue;
            addedValue = total/10;
            if (l1Len >= l2Len) {
                // use l1 to store data
                l1.val = total >= 10 ? total%10 : total;
            } else {
                // use l2 to store data
                l2.val = total >= 10 ? total%10 : total;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (addedValue > 0) {
            if (l1Len == l2Len) {
                ListNode node = new ListNode(addedValue);
                while(longerList.next != null) {
                    longerList = longerList.next;
                }
                longerList.next = node;
            } else {
                while(longerList.next != null) {
                    longerList = longerList.next;
                }
                while(addedValue > 0) {
                    int total = longerList.val + addedValue;
                    addedValue = total/10;
                    longerList.val = total >= 10 ? total%10 : total;
                    if (longerList.next == null) {
                        break;
                    }
                    longerList = longerList.next;
                }
                if (addedValue > 0) {
                    ListNode node = new ListNode(addedValue);
                    longerList.next = node;
                }
            }
        }
        return returnListNode;
    }

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
}