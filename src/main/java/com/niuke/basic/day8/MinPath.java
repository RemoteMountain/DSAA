package com.niuke.basic.day8;

public class MinPath {

    public static int process1(int[][] matrix, int i, int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            return matrix[i][j];
        }
        if (i == matrix.length - 1) {
            return matrix[i][j] + process1(matrix, i, j + 1);
        }
        if (j == matrix[0].length - 1) {
            return matrix[i][j] + process1(matrix, i + 1, j);
        }
        int right = process1(matrix, i, j + 1); //从当前位置往右走到右下角的最短路径
        int down = process1(matrix, i + 1, j); //从当前位置往下走到右下角的最短路径
        return matrix[i][j] + Math.min(right, down);
    }

    public static int process2(int[][] matrix, int i, int j) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int q = i;
        int p = j;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        if (i == matrix.length - 1 && j == matrix[0].length - 1) {
            dp[i][j] = matrix[i][j];
        }
        for (j = 1; j >= 0; j--) {
            dp[row-1][j] = matrix[row-1][j] + dp[row-1][j + 1];
        }
        for (i = 1; i >= 0; i--) {
            dp[i][col-1] = matrix[i][col-1] + dp[i + 1][col-1];
        }
        for (i = 1; i >= 0; i--) {
            for (j = 1; j >= 0; j--) {
                int down = matrix[i][j] + dp[i + 1][j];
                int right = matrix[i][j] + dp[i][j + 1];
                dp[i][j] = Math.min(down, right);
            }
        }
        return dp[p][q];
    }

    public static int minPath2(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(process2(matrix, 0, 0));
    }
}
