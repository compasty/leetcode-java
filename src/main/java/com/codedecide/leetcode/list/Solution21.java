package com.codedecide.leetcode.list;


/**
 * 合并两个有序链表
 * @author geckostroll
 * @version Solution21.java 2024年04月11日
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1, p2 = list2;
        // 虚拟节点
        ListNode dummy = new ListNode(0), cur = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if (p1 != null) {
            cur.next = p1;
        }
        if (p2 != null) {
            cur.next = p2;
        }
        return dummy.next;
    }
}
