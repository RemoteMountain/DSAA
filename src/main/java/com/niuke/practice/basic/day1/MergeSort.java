package com.niuke.practice.basic.day1;


/**
 * @Description : 归并排序  //描述
 * @Author : Liwang  //作者
 * @Date: 2021-04-03 21:41  //时间
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int l, int r) {

    }

    public static void merge(int[] arr, int l, int mid, int r) {
    }
}
