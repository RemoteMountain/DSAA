package com.niuke.advance.day2;

import java.util.LinkedList;

public class AllLessNumSubArray {

    public static int getNum1(int[] arr, int num) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (islessNumSubArr(arr, i, j, num)) {
                    res++;
                }
            }
        }
        return res;
    }

    private static boolean islessNumSubArr(int[] arr, int i, int j, int num) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            max = Math.max(max, arr[k]);
            min = Math.min(min, arr[k]);
        }
        return max - min <= num;
    }

    public static int getNum2(int[] arr, int num) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int res = 0;
        int L = 0;
        int R = 0;
        LinkedList<Integer> qMax = new LinkedList();
        LinkedList<Integer> qMin = new LinkedList();
        while (L< arr.length){
            while (R< arr.length){
                while (!qMax.isEmpty()&&arr[qMax.peekLast()]<=arr[R]){
                    qMax.pollLast();
                }
                qMax.addLast(R);
                while (!qMin.isEmpty()&&arr[qMin.peekLast()]>=arr[R]){
                    qMin.pollLast();
                }
                qMin.addLast(R);
                if (arr[qMax.peekFirst()] - arr[qMin.peekFirst()]>num){
                    break;
                }
                R++;
            }
            if (qMax.peekFirst() == L){
                qMax.pollFirst();
            }
            if (qMin.peekFirst() == L){
                qMin.pollFirst();
            }
            res += R - L;
            L++;
        }
        return res;
    }
}
