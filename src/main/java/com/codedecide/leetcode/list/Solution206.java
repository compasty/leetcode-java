package com.codedecide.leetcode.list;

/**
 * 反转链表：https://leetcode.cn/problems/reverse-linked-list/description/
 *
 * @author geckostroll
 * @version Solution206.java 2024年04月11日
 */
public class Solution206 {

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0), p = dummy;
        dummy.next = head;
        while (p != null) {
            ListNode tmp = p.next;
            if (tmp != null) {
                p.next = tmp.next;
                tmp.next = p;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1), n2 = new ListNode(2), n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode p = new Solution206().reverseList(n1);
        System.out.println(p.val);
    }
}
