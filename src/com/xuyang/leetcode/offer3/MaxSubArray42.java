package com.xuyang.leetcode.offer3;

/**
 * @author Li Xuyang
 * @date 2020/8/25 13:43
 * 剑指 Offer 42. 连续子数组的最大和
 */
public class MaxSubArray42 {
    //输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
    //
    //要求时间复杂度为O(n)。
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
