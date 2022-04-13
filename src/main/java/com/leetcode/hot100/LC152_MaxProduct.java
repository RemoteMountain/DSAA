package com.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 * 乘积最大子数组
 */
public class LC152_MaxProduct {

    public int maxProduct(int[] nums) {
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = max, mn = min;
            max = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            min = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            res = Math.max(res, max);
        }
        return res;
    }
}
