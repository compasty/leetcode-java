package com.codedecide.leetcode.list;

/**
 * @author geckostroll
 * @version Solution92.java 2024年04月04日
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode p = head, t = head;
        int i = 1;
        for (;i < left - 1; i++) {
            p = p.next;
        }
        ListNode head0 = p;
        while (i < right) {
            p = p.next;
            ListNode tmp = p.next;
            p.next = tmp.next;
            tmp.next = p;
            head0.next= tmp;
            i++;
        }
        return t;
    }
}
