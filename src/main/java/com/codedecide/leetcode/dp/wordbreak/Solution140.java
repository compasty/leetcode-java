package com.codedecide.leetcode.dp.wordbreak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 单词拆分II: https://leetcode.cn/problems/word-break-ii/description/
 * @author geckostroll
 * @version Solution140.java 2024年04月10日
 */
public class Solution140 {

    private List<String> resList;

    private LinkedList<String> track;

    public List<String> wordBreak(String s, List<String> wordDict) {
        resList = new ArrayList<>();
        track = new LinkedList<>();
        Map<Integer, Set<String>> wordMap = new HashMap<>();
        for (String word: wordDict) {
            int wordLen =word.length();
            wordMap.putIfAbsent(wordLen, new HashSet<>());
            wordMap.get(wordLen).add(word);
        }
        backtrack(s, wordMap, 0);
        return resList;
    }

    private String join(LinkedList<String> path) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        Iterator<String> iter = path.iterator();
        while (iter.hasNext()) {
            if (first) {
                sb.append(iter.next());
                first = false;
            } else {
                sb.append(' ');
                sb.append(iter.next());
            }
        }
        return sb.toString();
    }

    public void backtrack(String s, Map<Integer, Set<String>> wordMap, int start) {
        if (start == s.length()) {
            resList.add(join(track));
            return;
        }
        for (Map.Entry<Integer, Set<String>> entry: wordMap.entrySet()) {
            int end = start + entry.getKey();
            if (end > s.length()) {
                continue;
            }
            String part = s.substring(start, end);
            if (!entry.getValue().contains(part)) {
                continue;
            }
            track.add(part);
            backtrack(s, wordMap, end);
            track.removeLast();
        }
    }
}
