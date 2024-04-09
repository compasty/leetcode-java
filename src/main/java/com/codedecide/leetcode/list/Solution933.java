package com.codedecide.leetcode.list;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 最近的请求次数
 *
 * @author geckostroll
 * @version Solution933.java 2024年04月07日
 */
public class Solution933 {

    class RecentCounter {

        LinkedList<Integer> pingList;

        public RecentCounter() {
            this.pingList = new LinkedList<>();
        }

        public int ping(int t) {
            pingList.addLast(t);
            int v = t - 3000;
            Iterator<Integer> iter = pingList.iterator();
            while (iter.hasNext()) {
                if (iter.next() < v) {
                    iter.remove();
                } else {
                    break;
                }
            }
            return pingList.size();
        }
    }
}
