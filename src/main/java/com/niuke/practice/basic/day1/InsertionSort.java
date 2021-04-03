package com.niuke.practice.basic.day1;

/**
 * @Description : 插入排序 稳定  //描述
 * @Author : Liwang  //作者
 * @Date: 2021-04-03 21:21  //时间
 */
public class InsertionSort {

    public static void insrtionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
