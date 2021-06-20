package com.niuke.practice.advance;

public class SlidingWindowMaxArray {

    public static int[] getMaxArray(int[] arr, int w) {
        return null;
    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,3,5,4,3,3,6,7};
        printArray(getMaxArray(arr,3));
    }
}
