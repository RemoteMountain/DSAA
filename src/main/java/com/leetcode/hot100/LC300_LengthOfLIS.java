package com.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 最长递增子序列
 */
public class LC300_LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
