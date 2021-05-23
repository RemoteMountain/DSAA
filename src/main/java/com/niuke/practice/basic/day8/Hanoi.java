package com.niuke.practice.basic.day8;

public class Hanoi {

    public static void hanoi(int n) {
        if (n > 0) {
            func(n, n, "left", "mid", "right");
        }

    }

    private static void func(int rest, int down, String from, String help, String to) {
        if (rest == 1) {
            System.out.println("Move " + down + " from " + from + " to " + to);
        } else {
            func(rest - 1, down - 1, from, to, help);
            func(1, down, from, help, to);
            func(rest - 1, down - 1, help, from, to);
        }
    }

    public static void process(int n, String from, String help, String to) {
        if (n == 1) {
            System.out.println("Move 1 from " + from + " to " + to);
        } else {
            process(n - 1, from, to, help);
            System.out.println("Move " + n + " from " + from + " to " + to);
            process(n - 1, help, from, to);
        }
    }

    public static void main(String[] args) {
        hanoi(3);
    }
}
