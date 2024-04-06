package com.codedecide.leetcode.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author geckostroll
 * @version PriorityQueueTest.java 2024年04月05日
 */
public class PriorityQueueTest {

    @Test
    public void test1() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(2);
        for (int i = 1; i <= 10; i++) {
            queue.offer(i);
        }
        Assert.assertEquals((int)queue.peek(), 9);
    }
}
