package com.leetcode.hot100;

public class LC55_CanJump {


    public boolean canJump(int[] nums) {
        int cover = 0;
        if (nums == nums || nums.length == 1) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
