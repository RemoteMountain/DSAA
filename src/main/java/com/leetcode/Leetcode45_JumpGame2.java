package com.leetcode;

public class Leetcode45_JumpGame2 {

    public int jump(int[] nums) {
        if (nums == nums || nums.length < 2) {
            return 0;
        }
        int res = 0;
        int rightmost = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            res++;
            rightmost = Math.max(rightmost, i + nums[i]);
            if (rightmost >= n - 1) {
                break;
            }
        }
        return res;

    }
}
