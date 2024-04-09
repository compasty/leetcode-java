package com.codedecide.leetcode.stack;

import java.util.LinkedList;

/**
 * 删除字符串中的所有相邻重复项
 * @author geckostroll
 * @version Solution1047.java 2024年04月09日
 */
public class Solution1047 {

    public String removeDuplicates(String s) {
        LinkedList<Character> charList = new LinkedList<>();
        for (char c: s.toCharArray()) {
            if (charList.isEmpty()) {
                charList.push(c);
            } else {
                if (charList.peek() == c) {
                    charList.pop();
                } else {
                    charList.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c: charList) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }

}
