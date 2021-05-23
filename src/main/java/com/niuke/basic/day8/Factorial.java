package com.niuke.basic.day8;

//阶乘
public class Factorial {

    public static long getFactorial1(int n) {
        if (n == 1) {
            return 1L;
        } else {
            return n * getFactorial1(n - 1);
        }
    }

    public static long getFactorial2(int n) {
        long res = 1L;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(getFactorial1(n));
        System.out.println(getFactorial2(n));
    }

}
