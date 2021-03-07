package com.niuke.day1;


/*逆序对*/
public class ReversePairs {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r) + merge(nums, l, mid, r);
    }

    private int merge(int[] nums, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= r) {
            res += nums[p1] > nums[p2] ? r - p2 + 1 : 0;
            help[i++] = nums[p1] <= nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            help[i++] = nums[p1++];
        }
        while (p2 <= r) {
            help[i++] = nums[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            nums[l + j] = help[j];
        }
        return res;
    }
}
