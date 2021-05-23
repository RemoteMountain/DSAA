package com.niuke.basic.day8;

//汉诺塔问题
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
        System.out.println();
        process(3, "left", "mid", "right");
    }

    public static void moveLeftToRight(int n) {
        if (n == 1) {
            System.out.println("Move 1 from left to right");
        } else {
            moveLeftToMid(n - 1);
            System.out.println("Move " + n + "from left to right");
            moveMidToRight(n - 1);
        }

    }

    public static void moveLeftToMid(int n) {
        if (n == 1) {
            System.out.println("Move 1 from left to mid");
        } else {
            moveLeftToRight(n - 1);
            System.out.println("Move " + n + "from left to mid");
            moveRightToMid(n - 1);
        }
    }

    public static void moveMidToRight(int n) {
        if (n == 1) {
            System.out.println("Move 1 from mid to right");
        } else {
            moveMidToLeft(n - 1);
            System.out.println("Move " + n + "from mid to right");
            moveLeftToRight(n - 1);
        }
    }

    public static void moveRightToMid(int n) {
        if (n == 1) {
            System.out.println("Move 1 from right to mid");
        } else {
            moveRightToLeft(n - 1);
            System.out.println("Move " + n + "from right to mid");
            moveLeftToMid(n - 1);

        }
    }

    public static void moveMidToLeft(int n) {
        if (n == 1) {
            System.out.println("Move 1 from mid to left");
        } else {
            moveMidToRight(n - 1);
            System.out.println("Move " + n + "from mid to left");
            moveRightToLeft(n - 1);
        }
    }

    public static void moveRightToLeft(int n) {
        if (n == 1) {
            System.out.println("Move 1 from right to left");
        } else {
            moveRightToMid(n - 1);
            System.out.println("Move " + n + "from right to left");
            moveMidToLeft(n - 1);
        }
    }
}
