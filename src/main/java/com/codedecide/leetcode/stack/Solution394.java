package com.codedecide.leetcode.stack;

import java.util.LinkedList;

/**
 * 字符串解码：https://leetcode.cn/problems/decode-string/
 *
 * @author geckostroll
 * @version Solution304.java 2024年04月07日
 */
public class Solution394 {

    public String decodeString(String s) {
        StringBuffer sb = new StringBuffer(s.length() * 2);
        LinkedList<Character> list = new LinkedList<>();
        boolean digits = false, chars = false;
        int num = 0;
        for (char c: s.toCharArray()) {
            if (c == '[') {
                digits = false;
                chars = true;
                while (!list.isEmpty()) {
                    num = num * 10 + (list.pollLast() - '0');
                }
            } else if (c == ']') {
                chars = false;
                for (int i = 0; i < num; i++) {
                    for (char c2: list) {
                        sb.append(c2);
                    }
                }
                num = 0;
                list.clear();
            } else if (c >= '0' && c <= '9') {
                digits = true;
                list.push(c);
            } else {
                if (chars) {
                    list.addLast(c);
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution394().decodeString("3[a]2[bc]"));
    }

}
