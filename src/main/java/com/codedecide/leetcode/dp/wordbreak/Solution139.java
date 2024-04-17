package com.codedecide.leetcode.dp.wordbreak;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author geckostroll
 * @version Solution139.java 2024年04月04日
 */
public class Solution139 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        // 1表示可以，0表示未确认, -1表示不可以
        int[] dp = new int[len + 1];
        dp[0] = 1;
        Map<Integer, Set<String>> wordLenMap = new HashMap<>();
        for (String word: wordDict) {
            int wordLen = word.length();
            wordLenMap.putIfAbsent(wordLen, new HashSet<>());
            wordLenMap.get(wordLen).add(word);
        }
        for (int i = 1; i <= len; i++) {
            int val = -1;
            for (Map.Entry<Integer, Set<String>> entry: wordLenMap.entrySet()) {
                int wordLen = entry.getKey();
                if (i - wordLen >= 0 && dp[i - wordLen] != -1) {
                    String sub = s.substring(i - wordLen, i);
                    if (entry.getValue().contains(sub)) {
                        val = 1;
                        break;
                    }
                }
            }
            dp[i] = val;
        }
        return dp[len] == 1;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("applepenapple", Lists.newArrayList("apple", "pen")));
    }
}
