package com.leetcode.hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * 最长连续序列
 */
public class LC128_LongestConsecutive {

    public static int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int curCon = 1;
            int cur = num;
            while (set.contains(++cur)) {
                curCon++;
            }
            res = Math.max(res, curCon);
        }
        return res;
    }

    public static int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //key-num,value-num的最右连续的值，原始为num
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, num);
        }
        int res = 0;
        for (int num : nums) {
            if (map.containsKey(num - 1)) {
                continue;
            }
            int right = map.get(num);
            while (map.containsKey(right + 1)) {
                right = map.get(right + 1);
            }
            map.put(num, right);
            res = Math.max(res, right - num + 1);
        }
        return res;
    }

    public static int longestConsecutive3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //key-num,value-num的连续区域长度
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int value = left + right + 1;
            res = Math.max(res,value);
            map.put(num,value);
            map.put(num-left,value);
            map.put(num+right,value);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive1(nums));
    }


}
