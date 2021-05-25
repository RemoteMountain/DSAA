package com.niuke.practice.basic.day8;

public class MoneyProblem {

    public static boolean money1(int[] arr, int aim) {
        return process1(arr, aim, 0, 0);
    }


    public static boolean process1(int[] arr, int aim, int sum, int i) {
        if (i == arr.length) {
            return sum == aim;
        } else {
            return process1(arr, aim, sum, i + 1) ||
                    process1(arr, aim, sum + arr[i], i + 1);
        }
    }

    public static boolean money2(int[] arr, int aim) {
        if (arr == null || arr.length < 1) {
            return false;
        }
        int colL = 0;
        for (int i = 0; i < arr.length; i++) {
            colL += arr[i];
        }
        boolean[][] dp = new boolean[arr.length + 1][colL + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][aim] = true;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] ;
                if (j + arr[i]<=aim){
                    dp[i][j] = dp[i + 1][j] || dp[i+1][j + arr[i]];
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 7};
        int aim = 12;
        System.out.println(money1(arr, aim));
        System.out.println(money2(arr, aim));
    }
}
