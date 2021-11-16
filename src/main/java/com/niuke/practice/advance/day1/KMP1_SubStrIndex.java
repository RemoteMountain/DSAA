package com.niuke.practice.advance.day1;

//str1子串如果是str2，返回在str1开始下标
public class KMP1_SubStrIndex {

    public static int getIndexOf1(String str1, String str2) {
        if (str1 == null || str2 == null ||
                str1.length() == 0 || str2.length() == 0 ||
                str1.length() < str2.length()) {
            return -1;
        }
        return -1;
    }

    public static int getIndexOf2(String str1, String str2) {
        return -1;
    }

    private static int[] getNextArray(String str) {
        if (str.length() < 2) {
            return new int[]{-1};
        }
        int[] next = new int[str.length()];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < str.length()) {
            if (str.charAt(i - 1) == str.charAt(cn)) {
                next[i++] = ++cn;
            } else if (cn>0) {
                cn = next[cn];
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str1 = "acbacdegh";
        String str2 = "acd";
        System.out.println(getIndexOf1(str1, str2));
    }
}
