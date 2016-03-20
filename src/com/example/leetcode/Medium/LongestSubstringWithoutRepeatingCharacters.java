package com.example.leetcode.Medium;
/**
 * leetcode:3. Medium
 * Longest Substring Without Repeating Characters My Submissions Question
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * @author Administrator
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
//        String test1 = "abcabcbb";
//        String test2 = "bbbbb";
//        String test3 = "au";
        String test4 = "abba";
//        String test5 = "dvdf";

//        int len1 = lengthOfLongestSubstring(test1);
//        int len2 = lengthOfLongestSubstring(test2);
//        int len3 = lengthOfLongestSubstring(test3);
        int len4 = lengthOfLongestSubstring(test4);
//        int len5 = lengthOfLongestSubstring(test5);

//        System.out.println(len1);
//        System.out.println(len2);
//        System.out.println(len3);
//        System.out.println(len4);
        System.out.println(len4);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int start = 0, end = 1;
        int longestLen = 1;
        while (start <= end && end < s.length()) {
            char endChar = s.charAt(end);
            boolean flag = true;
            for(int i = start; i < end; i++) {
                if(endChar == s.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                longestLen = Math.max(longestLen, end-start+1);
                end++;
            } else {
                start++;
                if(start == end) {
                    end++;
                }
            }
        }
        return longestLen;
    }
}
