package com.codedecide.leetcode.list;

/**
 * 环形链表II: https://leetcode.cn/problems/linked-list-cycle-ii
 *
 * @author geckostroll
 * @version Solution142.java 2024年04月05日
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head, start = head;
        while (fast != null) {
            if (slow != null) {
                slow = slow.next;
            }
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                break;
            }
        }
        if (fast == null) {
            return null;
        }
        // 表示有环
        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }
        return start;
    }
}
