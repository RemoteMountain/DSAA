package com.leetcode;

public class Leetcode45_JumpGame2 {

    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int res = 0;
        int rightmost = 0;
        int n = nums.length;
        int end = 0;
        for (int i = 0; i < n - 1; i++) {
            rightmost = Math.max(rightmost,i+nums[i]);
            if (i == end){
                end = rightmost;
                res++;
            }
        }
        return res;

    }
}
