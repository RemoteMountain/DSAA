package com.niuke.practice.advance.day4;

import java.util.HashMap;
import java.util.Map;

public class MostEOR {

    public int mostEOR(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int[] dp = new int[arr.length];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0;
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            if (map.containsKey(xor)) {
                Integer pre = map.get(xor);
                dp[i] = pre == -1 ? 1 : dp[pre] + 1;
            }
            if (i > 0) {
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            res = Math.max(res, dp[i]);
            map.put(xor, i);
        }
        return res;
    }
}
