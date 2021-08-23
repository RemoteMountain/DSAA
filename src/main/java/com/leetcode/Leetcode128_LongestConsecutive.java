package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode128_LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(nums[num]);
        }
        for (int num : set) {
            int currentStreak = 1;
            if (set.contains(num - 1)) {
                continue;
            }
            while (set.contains(++num)) {
                currentStreak++;
            }
            res = Math.max(currentStreak, res);
        }
        return res;
    }
}
