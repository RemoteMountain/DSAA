package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode76_MinConverSubString {

    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Set<Character> tSet = new HashSet<>();
        for (int i = 0; i < tArr.length; i++) {
            tSet.add(tArr[i]);
        }
        StringBuilder subBuf = new StringBuilder("");
        String sub = "";
        for (int i = 0; i < sArr.length; i++) {
            for (int j = i; j < sArr.length; j++) {
                if (!tSet.contains(sArr[j])) {
                    break;
                }
                if ()
                    subBuf.append(sArr[j]);
            }


        }

    }
}
