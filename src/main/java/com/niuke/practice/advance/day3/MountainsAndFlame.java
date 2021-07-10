package com.niuke.practice.advance.day3;


public class MountainsAndFlame {

    public static long communications(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        //数组第一个最大值

        return 0;
    }

    private static long getInternalSum(int n) {
        return n == 1L ? 0L : (long) n * (long) (n - 1) / 2L;
    }

    //当前位置的下一个位置
    private static int nextIndex(int size, int index) {
        return index == size - 1 ? 0 : index + 1;
    }

    public static class Pair {
        private int value;
        private int times;

        public Pair(int value) {
            this.value = value;
            this.times = 1;
        }
    }


}
