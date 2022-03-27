package com.leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
//无重复字符的最长子串
public class LC3_LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int max = Integer.MIN_VALUE;
        while (l < s.length() && r < s.length()) {
            if (set.contains(s.charAt(r))) {
                max = Math.max(max, set.size());
                set.clear();
                l++;
                r = l;
                continue;
            }
            set.add(s.charAt(r));
            r++;
        }
        return Math.max(max, set.size());
    }

}
