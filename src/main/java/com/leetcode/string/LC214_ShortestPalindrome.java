package com.leetcode.string;

//最短回文串
public class LC214_ShortestPalindrome {

    public static String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s + s;
        }
        String revS = new StringBuilder(s).reverse().toString();
        String m = revS + "#" + s;
        int i = getMaxPalindromeNextArray(m);
        String add = new StringBuilder(s.substring(i)).reverse().toString();
        return add + s;
    }

    private static int getMaxPalindromeNextArray(String s) {
        if (s == null) {
            return -1;
        }
        int[] next = new int[s.length() + 1];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cnt = 0;
        while (pos < next.length) {
            if (s.charAt(pos - 1) == s.charAt(cnt)) {
                next[pos++] = ++cnt;
            } else if (cnt > 0) {
                cnt = next[cnt];
            } else {
                next[pos++] = 0;

            }
        }
        return next[s.length()];
    }
}
