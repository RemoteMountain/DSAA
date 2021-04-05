package com.niuke.practice.basic.day2;

/**
 * @Description : 两数最大差值  //描述
 * @Author : Liwang  //作者
 * @Date: 2021-04-05 11:13  //时间
 */
public class MaxGap {

    public static int maxGap(int[] arr) {
        return 0;
    }

    public static int bucket(int len, int num, int min, int max) {
        return (int) (num - min) * len / (max - min);
    }
}
