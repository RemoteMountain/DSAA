package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Leetcode202102 {

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
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return 1.0 * maxSum / k;
    }

    /*1208  尽可能使字符串相等
     * */
    public int equalSubstring(String s, String t, int maxCost) {
        byte[] sBytes = s.getBytes();
        byte[] tBytes = t.getBytes();
        int n = s.length();
        /*
        int cons = 0;
        int i = 0;
        for (i = 0; i < sBytes.length; i++) {
            cons += Math.abs(sBytes[i] - tBytes[i]);
            *//*while (i == 0){
                if (cons <= maxCost){
                    return 0;
                }
            }*//*
            while (cons >=maxCost){
                continue;
            }
        }
        if (cons == maxCost){
            return i+1;
        }else {
            return i;
        }*/
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(sBytes[i] - tBytes[i]);
        }
        int start = 0, end = 0, sum = 0, maxLength = 0;
        while (end < n) {
            sum += diff[end];
            while (sum > maxCost) {
                sum -= diff[start];
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }

    /*
     * 888. 公平的糖果棒交换*/
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int delta = (sumA - sumB) / 2;
        int[] ans = new int[2];
        Set<Integer> aSet = new HashSet();
        for (int a : A) {
            aSet.add(a);
        }
        for (int y : B) {
            int x = y + delta;
            if (aSet.contains(x)) {
                ans[0] = x;
                ans[1] = y;
            }

        }
        return ans;
        /*int i = 0;
        int j = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        while (i < aN && j < bN) {
            int x = A[i];
            int y = B[j];
            if (x - y > delta) {
                j++;
            } else if (x - y < delta) {
                i++;
            } else {
                ans[0] = x;
                ans[1] = y;
            }
        }*/

    }

    /*424. 替换后的最长重复字符
     * */
    public int characterReplacement(String s, int k) {
        return 1;
    }

    /*665. 非递减数列
     */
    public boolean checkPossibility(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        return false;
    }


}
