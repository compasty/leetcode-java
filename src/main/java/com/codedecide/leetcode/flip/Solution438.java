package com.codedecide.leetcode.flip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 找出字符串中所有字母异位词：https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/
 *
 * @author geckostroll
 * @version Solution438.java 2024年04月06日
 */
public class Solution438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> idxList = new ArrayList<>();
        if (s.length() < p.length()) {
            return idxList;
        }
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            if (right - left >= p.length()) {
                // 在这里判断是否找到了合法的子串
                if (valid == need.size()) {
                    idxList.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        // 未找到符合条件的子串
        return idxList;
    }

}
