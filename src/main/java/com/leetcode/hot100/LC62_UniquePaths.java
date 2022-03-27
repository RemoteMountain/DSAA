package com.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/unique-paths/
 * 不同路径
 */
public class LC62_UniquePaths {

    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int j = 0; j < m; j++) {
            dp[j][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        uniquePaths(3, 7);
    }


}
