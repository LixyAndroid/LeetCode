package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/7/28 22:00
 * 剑指 Offer 42. 连续子数组的最大和
 */
public class MaxSubArray42 {

    //动态规划，想状态转移方程
    /*
    输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
    要求时间复杂度为O(n)。
     */

    public static int maxSubArray(int[] nums) {

        int sumMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            sumMax = Math.max(sumMax, nums[i]);
        }
        return sumMax;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int resMax = maxSubArray(nums);
        System.out.println(resMax);
    }

}
