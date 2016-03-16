package com.example.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * leetcode 20. Easy
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

   The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author yuhongliang
 *
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        // init map
        HashMap<Character, Character> charMaps = new HashMap<Character, Character>();
        charMaps.put('(', ')');
        charMaps.put('{', '}');
        charMaps.put('[', ']');

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (charMaps.containsKey(character)) {
                stack.push(character);
            }
            if (charMaps.containsValue(character)) {
                // 从stack中获取栈顶的内容
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (charMaps.get(top) == character) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "()[]{}()";
        boolean valid = isValid(s);
        System.out.println(valid);
        s = "()[";
        valid = isValid(s);
        System.out.println(valid);
    }
}
