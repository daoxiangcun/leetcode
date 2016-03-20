package com.example.leetcode.Easy;

/**
 * leetcode 58. Easy
 * Length of Last Word
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
   If the last word does not exist, return 0.
   Note: A word is defined as a character sequence consists of non-space characters only.
   For example,
   Given s = "Hello World",
   return 5.
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int p = 0, q = 0;
        int len = 0;
        s = s.trim();
        while(q < s.length()) {
            // 璺宠繃寮�ご绌烘牸
            while(q < s.length() && s.charAt(q) == ' ') {
                q++;
            }
            p = q;
            // 璁＄畻闀垮害
            while(q < s.length() && s.charAt(q) != ' ') {
                q++;
            }
            len = q - p;
        }
        return len;
    }

    public static void main(String[] args) {
        String str = "a ";
        int length = lengthOfLastWord(str);
        System.out.println(length);
    }
}
