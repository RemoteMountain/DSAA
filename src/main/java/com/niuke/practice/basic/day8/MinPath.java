package com.niuke.practice.basic.day8;

public class MinPath {

    public int minPath1(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        return process(m, 0, 0);

    }

    private int process(int[][] m, int i, int j) {
        if (i == m.length - 1 && j == m[0].length - 1) {
            return m[i][j];
        }
        if (i == m.length - 1) {
            return m[i][j] + process(m, i, j + 1);
        }
        if (j == m[0].length - 1) {
            return m[i][j] + process(m, i + 1, j);
        }
        return m[i][j] + Math.min(process(m, i + 1, j), process(m, i, j + 1));
    }

    public int minPath2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = grid[row - 1][col - 1];
        for (int i = row - 2; i >= 0; i--) {
            dp[i][col - 1] = dp[i + 1][col - 1] + grid[i][col - 1];
        }
        for (int j = col - 2; j >= 0; j--) {
            dp[row - 1][j] = dp[row - 1][j + 1] + grid[row - 1][j];
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }
}
