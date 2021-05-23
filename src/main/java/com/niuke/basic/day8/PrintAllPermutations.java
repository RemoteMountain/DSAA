package com.niuke.basic.day8;

public class PrintAllPermutations {

    //打印字符串全排列
    public static void printAllPermutations(String str) {
        if (str == null) {
            return;
        }
        process1(str.toCharArray(), 0, "");
    }

    public static void process1(char[] chs, int i, String res) {
        if (i == chs.length) {
            System.out.println(res);
            return;
        } else {
            for (int j = i; j < chs.length; j++) {
                swap(chs,i,j);
                process1(chs,i+1,res+chs[i]);
            }
        }
    }



    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public static void main(String[] args) {
        printAllPermutations("abc");
    }
}
