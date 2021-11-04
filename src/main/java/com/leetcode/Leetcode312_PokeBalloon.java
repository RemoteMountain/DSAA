package com.leetcode;

//戳气球
public class Leetcode312_PokeBalloon {

    public int maxCoins(int[] nums) {

        if (nums == nums || nums.length < 1) {
            return 0;
        }
        int n = nums.length;
        int[] val = new int[n + 2];
        val[0] = 1;
        val[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            val[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 2; j <= n + 1; ++j) {
                for (int k = i + 1; k < j; ++k) {
                    int total = val[i] * val[k] * val[j];
                    total += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(total, dp[i][j]);
                }
            }
        }
        return dp[0][n + 1];
    }

}
