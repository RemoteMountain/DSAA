package com.niuke.day5;

public class BooleanFilterTest {

    public static void main(String[] args) {
        /*System.out.println("1: " + Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(1 << 16));
        System.out.println(31%32);*/
        int[] arr = new int[1000]; //32*1000bit
        int index = 30000; //把第30000个bit位设置为1.
        int intIndex = index / 32; //先定位是int数组哪个下标。
        int bitIndex = index % 32; //某个下标，32个bit位其中一个。
        arr[intIndex] = arr[intIndex] | (1 << bitIndex);

        System.out.println(Integer.toBinaryString(1 << 16));
    }
}
