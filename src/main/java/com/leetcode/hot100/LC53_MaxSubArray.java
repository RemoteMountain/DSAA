package com.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 最大子数组和
 */
public class LC53_MaxSubArray {

    public static int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int[] dp = new int[length];
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max,dp[i]);

        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
