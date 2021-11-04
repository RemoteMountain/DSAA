package com.niuke.advance.day6;

import java.util.HashMap;
import java.util.Map;

//换钱的方法
public class CoinsWay {

    /**
     * 暴力递归
     *
     * @param arr 纸币数组
     * @param aim 目标钱数
     * @return
     */
    public static int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim <= 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    /**
     * @param arr
     * @param index 从index开始直到数组最后位置的钱币可以任意组合
     * @param aim
     * @return
     */
    public static int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    /**
     * 此问题是无后效性问题，前面的选择组合对之后的组合数没有影响
     * 只要index和aim固定，那么组合数是一定不变的。
     */


    /**
     * 使用map保存index和aim固定时的结果，避免重复计算
     *
     * @param arr
     * @param index
     * @param aim
     * @return
     */
    public static Map<String, Integer> map = new HashMap();

    public static int process2(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                int nextAim = aim - arr[index] * i;
                int nextIndex = index + 1;
                String key = nextIndex + "_" + nextAim;
                if (map.containsKey(key)) {
                    res += map.get(key);
                } else {
                    res += process1(arr, nextIndex, nextAim);
                }
            }
        }
        map.put(index + "_" + aim, res);
        return res;
    }

    /**
     * DP求解
     *
     * @param arr
     * @param aim
     * @return
     */
    public static int coins2(int arr[], int aim) {
        if (arr == null || arr.length == 0 || aim <= 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = 1;

        }
        for (int j = 1; arr[arr.length - 1] * j <= aim; j++) {
            dp[arr.length - 1][arr[arr.length - 1] * j] = 1;
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = 1; j <= aim; j++) {
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    dp[i][j] += dp[i + 1][j - arr[i] * k];
                }
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] coins = {10, 5, 1, 25};
        int aim = 2000;
        System.out.println(coins1(coins, aim));
        System.out.println(coins2(coins, aim));
    }
}
