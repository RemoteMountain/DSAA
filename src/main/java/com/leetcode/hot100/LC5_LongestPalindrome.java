package com.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最长回文子串
 */
public class LC5_LongestPalindrome {

    //中心扩展法
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (s == null || n == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = longestPalindromeLength(s, i, i);
            int l2 = longestPalindromeLength(s, i, i + 1);
            int length = Math.max(l1, l2);
            if (length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    //字符串的最大回文串长度
    private static int longestPalindromeLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
