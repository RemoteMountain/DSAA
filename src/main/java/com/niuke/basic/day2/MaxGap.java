package com.niuke.basic.day2;

public class MaxGap {

    /*求排序后，数组相邻两数最大差值*/
    public int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[n + 1];
        int[] mins = new int[n + 1];
        int[] maxs = new int[n + 1];
        int bid = 0;
        for (int i = 0; i < n; i++) {
            bid = bucket(arr[i], n, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= n; i++) {
            if (hasNum[i]) {
                res = Math.max(lastMax, mins[i] - lastMax);
                lastMax = maxs[i];
            }

        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }
}
