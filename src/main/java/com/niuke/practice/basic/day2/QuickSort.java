package com.niuke.practice.basic.day2;

/**
 * @Description : 快速排序  //描述
 * @Author : Liwang  //作者
 * @Date: 2021-04-04 21:00  //时间
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
    }

    private static int[] partition(int[] arr, int l, int r) {
        return null;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

