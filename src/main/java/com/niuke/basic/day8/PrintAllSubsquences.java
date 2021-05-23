package com.niuke.basic.day8;


public class PrintAllSubsquences {

    //字符串所有子序列
    private static void printAllSubsquences(char[] chs, int i, String res) {
        if (i == chs.length) {
            System.out.println(res);
            return;
        } else {
            printAllSubsquences(chs, i + 1, res + "");
            printAllSubsquences(chs, i + 1, res + String.valueOf(chs[i]));
        }
    }

    public static void main(String[] args) {
        printAllSubsquences("abc".toCharArray(),0,"");
        System.out.println("--------------");

    }

}
