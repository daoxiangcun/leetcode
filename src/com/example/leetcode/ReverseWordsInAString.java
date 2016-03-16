package com.example.leetcode;
/**
 * leetcode 151. Medium
 * 151. Reverse Words in a String My Submissions Question
 * Given an input string, reverse the string word by word.

   For example,
   Given s = "the sky is blue",
   return "blue is sky the".

   Update (2015-02-12):
   For C programmers: Try to solve it in-place in O(1) space.

   click to show clarification.

   Clarification:
   What constitutes a word?
   A sequence of non-space characters constitutes a word.
   Could the input string contain leading or trailing spaces?
   Yes. However, your reversed string should not contain leading or trailing spaces.
   How about multiple spaces between two words?
   Reduce them to a single space in the reversed string.
 */
public class ReverseWordsInAString {
    private static String reverseString(String s, int start, int end) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        // skip heading spaces
        StringBuilder sb = new StringBuilder(s.substring(start, end));
        int len = sb.length();
        int p = 0, q = len-1;
        while(p <= q && q >= 0) {
            char pValue = sb.charAt(p);
            char qValue = sb.charAt(q);
            sb.setCharAt(p, qValue);
            sb.setCharAt(q, pValue);
            p++;
            q--;
        }
        return sb.toString();
    }

    public static String reverseWords(String s) {
        StringBuilder resultSB = new StringBuilder();
        s = s.trim();
        String reversedStr = reverseString(s, 0, s.length());
        int p = 0, q = 0;
        while(q < reversedStr.length()) {
            // 跳过空格
            while (q < reversedStr.length()) {
                if (reversedStr.charAt(q) == ' ') {
                    q++;
                } else {
                    break;
                }
            }
            p = q;
            while (q < reversedStr.length()) {
                if (reversedStr.charAt(q) != ' ') {
                    q++;
                } else {
                    break;
                }
            }
            resultSB.append(reverseString(reversedStr, p, q));
            if (q != reversedStr.length()) {
                resultSB.append(" ");
            }
        }
        return resultSB.toString();
    }

    public static void main(String[] args) {
        String str = "a";
        String reversedStr = reverseWords(str);
        System.out.println(reversedStr);
    }
}
