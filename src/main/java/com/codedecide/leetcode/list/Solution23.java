package com.codedecide.leetcode.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author geckostroll
 * @version Solution.java 2024年04月04日
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = new ListNode(0), head = node;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        while (!queue.isEmpty()) {
            ListNode tmp = queue.poll();
            node.next = tmp;
            node = node.next;
            if (tmp.next != null) {
                queue.offer(tmp.next);
            }
        }
        return head.next;
    }
}
