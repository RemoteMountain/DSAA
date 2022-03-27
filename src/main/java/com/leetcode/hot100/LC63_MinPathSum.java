package com.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 最小路径和
 */
public class LC63_MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = dp[m - 1][i + 1] + grid[m - 1][i];
        }
        for (int j = m - 2; j >= 0; j--) {
            dp[j][n - 1] = dp[j + 1][n - 1] + grid[j][n - 1];

        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[0][0];
    }
}
