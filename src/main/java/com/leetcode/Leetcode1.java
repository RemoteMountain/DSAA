package com.leetcode;

import java.util.regex.Matcher;

public class Leetcode1 {

    /*
     * 643. 子数组最大平均数 I*/
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        //滑动窗口第一次放满k个数字，计算k个数字和
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < n; i++) {
            sum = sum - nums[i-k] + nums[i];
            maxSum = Math.max(maxSum,sum);
        }
        return 1.0 * maxSum / k;
    }

    public int equalSubstring(String s, String t, int maxCost) {
        byte[] sBytes = s.getBytes();
        byte[] tBytes = t.getBytes();
        int cons = 0;
        int i = 0;
        for (i = 0; i < sBytes.length; i++) {
            cons += Math.abs(sBytes[i] - tBytes[i]);
            /*while (i == 0){
                if (cons <= maxCost){
                    return 0;
                }
            }*/
            while (cons >=maxCost){
                continue;
            }
        }
        if (cons == maxCost){
            return i+1;
        }else {
            return i;
        }
    }


}
