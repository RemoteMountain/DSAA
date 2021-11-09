package com.leetcode.string;

public class LC28_StrStr {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null ||
                haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = getNextArray(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (next[j] == -1) {
                i++;
            } else {
                j = next[j];

            }
        }
        return j == needle.length() ? i - j : -1;
    }

    private int[] getNextArray(String str) {
        if (str == null || str.length() == 0 || str.length() == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str.length()];
        next[0] = -1;
        next[1] = 0;
        int index = 2;
        int cnt = 0;
        while (index < next.length) {
            if (str.charAt(index - 1) == str.charAt(cnt)) {
                next[index++] = ++cnt;
            } else if (cnt > 0) {
                cnt = next[cnt];
            } else {
                next[index++] = 0;
            }
        }
        return next;
    }
}
