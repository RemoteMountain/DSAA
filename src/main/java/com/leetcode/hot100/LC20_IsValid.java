package com.leetcode.hot100;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 有效的括号
 */
public class LC20_IsValid {

    public boolean isValid(String s) {
        int n = s.length();
        if (s == null || n == 0) return true;
        if (n % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || s.charAt(i) != stack.peek()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();

    }
}
