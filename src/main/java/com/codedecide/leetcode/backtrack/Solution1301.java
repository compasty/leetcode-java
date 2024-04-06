package com.codedecide.leetcode.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/number-of-paths-with-max-score/
 *
 * @author geckostroll
 * @version Solution1301.java 2024年04月05日
 */
public class Solution1301 {

    public static class Cood {
        public int x;
        public int y;
        public int sum;
        public Cood() {}
        public Cood(int x, int y) {
            this.x = x;
            this.y = y;
            this.sum = 0;
        }

    }

    public int[] pathsWithMaxScore(List<String> board) {
        LinkedList<Cood> path = new LinkedList<>();
        long max = 0, maxCnt = 0;
        Cood start = new Cood(board.size(), board.get(board.size() - 1).length() - 1);
        path.add(start);
        backtrack(path, board, max, maxCnt);
        // TODO
        return null;
    }

    private void backtrack(LinkedList<Cood> path, List<String> board, long max, long maxCnt) {
//        Cood cood = path.peek();
//        if (cood.x == 0 && cood.y == 0) {
//            // 表示到达起点
//            if (cood.sum > max) {
//                max = cood.sum;
//                maxCnt = 1;
//            } else if ()
//        }

    }
}
