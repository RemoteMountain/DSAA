package com.leetcode.hot100;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 盛最多水的容器
 */
public class LC10_MaxArea {

    //双指针法
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
