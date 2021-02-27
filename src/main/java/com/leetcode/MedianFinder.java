package com.leetcode;

import java.util.PriorityQueue;

/**
 * @Description : 数据流中位数  //描述
 * @Author : Liwang  //作者
 * @Date: 2021-02-23 18:48  //时间
 */
public class MedianFinder {
    private PriorityQueue<Integer> big;
    private PriorityQueue<Integer> small;

    public MedianFinder(int n) {
        if (n<0){
            throw new RuntimeException("init fail");
        }
        big = new PriorityQueue(n);
        small = new PriorityQueue(n);
    }

    public void addNum(int num) {

    }

    public double findMedian() {
        return 0;

    }
}
