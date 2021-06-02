package com.niuke.basic.day8;

public class Knapsack {

    public static int process1(int[] weights, int[] values, int i, int w, int v) {
        if (i == weights.length || w - weights[i] < 0) {
            return v;
        }
        int v1 = process1(weights, values, i + 1, w, v);
        int v2 = process1(weights, values, i + 1, w - weights[i], v + values[i]);
        return Math.max(v1, v2);
    }

    public static int process2(int[] weights, int[] values, int w) {
        int[][] dp = new int[weights.length + 1][w + 1];
        for (int i = weights.length - 1; i >= 0; i--) {
            for (int j = w; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + weights[i] <= w) {
                    dp[i][j] = Math.max(dp[i + 1][j], values[i] + dp[i + 1][j + weights[i]]);
                }
            }
        }
        return dp[0][0];

    }


    public static void main(String[] args) {
        int[] weights = { 3, 2, 4, 7 };
        int[] values = { 5, 6, 3, 19 };
        System.out.println(process1(weights, values, 0, 6, 0));
        System.out.println(process2(weights, values, 6));
    }
}
