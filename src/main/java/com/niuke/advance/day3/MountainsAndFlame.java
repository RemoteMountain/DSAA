package com.niuke.advance.day3;

import java.util.Scanner;
import java.util.Stack;

//能相互看见烽火的山峰对个数
public class MountainsAndFlame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int size = scanner.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(communications(arr));
        }
        scanner.close();
    }

    public static int nextIndex(int size, int i) {
        return i < (size - 1) ? (i + 1) : 0;
    }

    public static long getInternalSum(int n) {
        return n == 1L ? 0L : (long) n * (long) (n - 1) / 2L;

    }

    public static class Pair {
        public int value;
        public int times;

        public Pair(int value) {
            this.value = value;
            this.times = 1;
        }
    }

    private static long communications(int[] arr) {
        int size = arr.length;
        if (arr == null || size < 2) {
            return 0;
        }
        int maxIndex = 0;
        for (int i = 0; i < size; i++) {
            maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
        }
        int value = arr[maxIndex];
        int index = nextIndex(size, maxIndex);
        long res = 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(value));
        while (index != maxIndex) {
            value = arr[index];
            while (!stack.isEmpty() && stack.peek().value < value) {
                int times = stack.pop().times;
                /*res += getInternalSum(times) + times;
                res += stack.isEmpty() ? 0 : times;*/
                res += getInternalSum(times) + 2 * times;
            }
            if (!stack.isEmpty() && stack.peek().value == value) {
                stack.peek().times++;
            } else {
                stack.push(new Pair(value));
            }
            index = nextIndex(size, index);
        }
        while (!stack.isEmpty()) {
            int times = stack.pop().times;
            res += getInternalSum(times);
            if (!stack.isEmpty()) {
                res += times;
                if (stack.size() > 1) {
                    res += times;
                } else {
                    res += stack.peek().times > 1 ? times : 0;
                }
            }

        }
        return res;
    }

}
