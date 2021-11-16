package com.niuke.practice.advance.day1;

public class KMP2_ShortestHaveTwice {

    public String twiceStr(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str + str;
        }
        if (str.length() == 2) {
            return str.charAt(0) == str.charAt(1) ? str + str.charAt(0) : str + str;
        }
        int endIndex = endIndexLength(str);
        return str + str.substring(endIndex);
    }

    private int endIndexLength(String str) {
        int[] next = new int[str.length() + 1];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (str.charAt(pos - 1) == str.charAt(cn)) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next[next.length - 1];
    }
}
