package com.example.leetcode;

import java.util.ArrayList;

/**
 * leetcode 258. Easy
 * Add Digits
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

   For example:

   Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

   Follow up:
   Could you do it without any loop/recursion in O(1) runtime?
 *
 */
public class AddDigits {
    public static int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        // 得到num各位数然后相加
        int newNum = 0;
        while(num > 0) {
            newNum += num%10;
            num /= 10;
        }
        return addDigits(newNum);
    }

    public static void main(String[] args) {
        int data = 38;
        int value = addDigits(data);
        System.out.println(value);
    }
}
