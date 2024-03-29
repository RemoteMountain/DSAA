package com.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * 爬楼梯
 */
public class LC70_ClimbStairs {

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }
}
