package com.niuke.practice.basic.day8;

public class Factorial {

    public static long getFactorial1(int n) {
        if (n == 1) {
            return 1L;
        } else {
            return n * getFactorial1(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(getFactorial1(3));
    }
}
