package com.niuke.day2;

public class Day2 {

    /*
    * 给定一个数组arr，和一个数num，请把小于等于num的数放在数
      组的左边，大于num的数放在数组的右边。*/
    /*0-x是小于等于区域，遍历一遍数组，如果arr[i]小于等于num，则arr[i]与arr[x+1]交换，x++*/
    public static void partition(int[] arr, int num) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int x = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                swap(arr, ++x, i);
            }
        }
    }

    /*荷兰旗问题
    * 给定一个数组arr，和一个数num，请把小于num的数放在数组的
      左边，等于num的数放在数组的中间，大于num的数放在数组的
       右边。*/
    /*l-less小于区域，more-r大于区域，小于区域发生交换l+1，大于区域发生交换l不变，arr[l]==num，l+1*/
    public static int[] partition(int[] arr, int l, int r, int num) {
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (arr[l] < num) {
                swap(arr, l++, ++less);
            } else if (arr[l] > num) {
                swap(arr, l, --more);
            } else {
                l++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, l++, ++less);
            } else if (arr[l] > arr[r]) {
                swap(arr, l, --more);
            } else {
                l++;
            }
        }
        swap(arr, r, more);
        return new int[]{less + 1, more};
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + "");
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 1};
        int[] partition = partition(arr, 0, arr.length - 1);
        System.out.println(partition[0]);
        System.out.println(partition[1]);

        arr = new int[]{1, 2, 3, 4, 5, 1};
        int[] partition1 = partition(arr, 0, arr.length - 1, 1);
        System.out.println(partition1[0]);
        System.out.println(partition1[1]);

    }


}
