package com.codedecide.leetcode.trie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单词替换：https://leetcode.cn/problems/replace-words
 * @author geckostroll
 * @version Solution648.java 2024年04月08日
 */
public class Solution648 {

    public static class Trie {

        private boolean end;

        private Map<Character, Trie> children;

        public Trie() {
            this.end = false;
            this.children = new HashMap<>();
        }

        public void addWord(String word) {
            Trie cur = null;
//            for (char c: word.toCharArray()) {
//                node = children.get(c);
//                if (node == null) {
//
//                }
//                if (children.containsKey(c)) {
//                    node =
//                }
//            }
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuffer sb = new StringBuffer();
        Trie trie = new Trie();
        for (String word: dictionary) {
            trie.addWord(word);
        }
        // TODO
        return null;
        //        for (int i= 0; i < )
    }
}
