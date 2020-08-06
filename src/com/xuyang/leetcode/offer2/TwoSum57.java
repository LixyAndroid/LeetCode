package com.xuyang.leetcode.offer2;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/8/6 20:21
 * 剑指 Offer 57. 和为s的两个数字
 */
public class TwoSum57 {
    //输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int k = target - nums[left];
            if (nums[right] > k) {
                right--;
            } else if (nums[right] < k) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 10, 11, 15, 30, 70, 90};
        int[] nums2 = {45, 46, 67, 73, 74, 74, 77, 83, 89, 98};
        int[] res = twoSum(nums2, 147);
        System.out.println(Arrays.toString(res));
    }
}
