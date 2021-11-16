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
        if (s.length() == 2){
            return "";
        }
        return "";
    }
}
