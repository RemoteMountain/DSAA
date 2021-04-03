package com.niuke.practice.basic.day1;

/**
 * @Description : 小和问题  //描述
 * @Author : Liwang  //作者
 * @Date: 2021-04-03 21:53  //时间
 */
public class SmallSum {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return smallSum(arr, 0, arr.length - 1);
    }

    public static int smallSum(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 2);
        return smallSum(arr, l, mid) + smallSum(arr, mid + 1, l) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        return 0;
    }
}
