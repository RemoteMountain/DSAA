package com.leetcode.array;

public class Leetcode76_MinConverSubString {

    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int i = 0;
        int j = 0;
        int start = 0;
        int needCnt = t.length();
        int minSize = Integer.MAX_VALUE;
        while (j < s.length()) {
            if (need[s.charAt(j)] > 0) {
                needCnt--;
            }
            need[s.charAt(j)]--;
            if (needCnt == 0) {
                while (i < j && need[s.charAt(i)] < 0) {
                    need[s.charAt(i)]++;
                    i++;
                }
                if (j - i + 1 < minSize) {
                    minSize = j - i + 1;
                    start = i;
                }
                need[s.charAt(i)]++;
                i++;
                needCnt++;

            }
            j++;
        }
        return minSize == Integer.MAX_VALUE ? "" : s.substring(start, start + minSize);
    }


    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
        System.out.println(s.substring(0, 2));
    }
}
