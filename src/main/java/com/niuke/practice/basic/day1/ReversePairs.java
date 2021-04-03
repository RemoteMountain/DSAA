package com.niuke.practice.basic.day1;

/**
 * @Description : 逆序对  //描述
 * @Author : Liwang  //作者
 * @Date: 2021-04-03 22:15  //时间
 */
public class ReversePairs {

    public static int reversePairs(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return reversePairs(arr, 0, arr.length - 1);
    }

    public static int reversePairs(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 2);
        return reversePairs(arr, l, mid) + reversePairs(arr, mid + 1, l) + merge(arr, l, mid, r);
    }

    private static int merge(int[] arr, int l, int mid, int r) {
        return 0;
    }
}
