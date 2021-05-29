package com.niuke.advance;

public class KMP {

    public static void main(String[] args) {
        String str1 = "abc123def";
        String str2 = "123d";
        System.out.println(str1.indexOf(str2));
        System.out.println(getIndexOf1(str1, str2));
    }

    //O(n*m)
    public static int getIndexOf1(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return -1;
        }
        if (str1.length() < str2.length()) {
            return -1;
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for (int i = 0; i < ch1.length; i++) {
            int x = i;
            for (int j = 0; j < ch2.length; j++) {
                if (ch1[x++] != ch2[j]) {
                    break;
                }
                if (j == ch2.length - 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    //KMP 加速匹配过程
    public static int getIndexOf2(String str1, String str2) {
        if (str1 == null || str2 == null || str2.length() < 1 || str1.length() < str2.length()) {
            return -1;
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(str2);
        while (i1 < str1.length() && i2 < str2.length()) {
            if (ch1[i1] == ch2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == ch2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(String str) {
        char[] chs = str.toCharArray();
        if (chs.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[chs.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (chs[i - 1] == chs[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
