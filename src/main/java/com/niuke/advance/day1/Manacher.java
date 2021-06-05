package com.niuke.advance.day1;

public class Manacher {

    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str);
        //额外数组，记录每个位置回文半径
        int[] pArr = new int[charArr.length];
        int C = -1;
        int R = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            /**
             * i关于C对称的i1位置：2 * C - i
             *
             * i在R内或不在R内，都有一个不用验证的区域构成回文，
             * i不在R内，i位置自身不用验证，所以先赋值回文半径为1。
             * i在R内，可能性2、3、4回文半径较小者不用验证，所以先赋值为两者较小者。
             */
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            /**
             * 此时在不用验证区域的基础上继续向两边扩展比较
             * 可能性2、3会扩展失败
             * 可能性1、4看扩展两边是否相等
             */
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            //计算过程中，回文右边界和回文半径会可能变大
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    public static void main(String[] args) {
        String str1 = "abc1234321ab";
        System.out.println(maxLcpsLength(str1));
    }
}
