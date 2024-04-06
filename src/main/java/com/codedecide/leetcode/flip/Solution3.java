package com.codedecide.leetcode.flip;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 无重复字符的最长子串：https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/
 *
 * @author geckostroll
 * @version Solution3.java 2024年04月05日
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int left = 0, right = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int res = 0;
        while (right < len) {
            char c = s.charAt(right);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            right++;

            while (left < right && charMap.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                charMap.put(d, charMap.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
