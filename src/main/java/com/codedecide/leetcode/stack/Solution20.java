package com.codedecide.leetcode.stack;

import java.util.Stack;

/**
 * @author geckostroll
 * @version Solution20.java 2024年04月04日
 */
public class Solution20 {

    public boolean isRight(char left, char right) {
        switch (left) {
            case '{': return right == '}';
            case '[': return right == ']';
            case '(': return right == ')';
            default: return false;
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c2 = stack.pop();
                if (!isRight(c2, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
