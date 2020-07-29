package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/7/29 22:13
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 */
public class MissingNumber53 {
    //一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
    // 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
    public static int missingNumber(int[] nums) {
        if (nums[0] != 0) {
            return 0;
        }
        int len = nums.length + 1;
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            tmp[i] = i;
        }
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != tmp[index]) {
                return tmp[index];
            }
            index++;
        }

        return tmp[index];

    }

    //排序数组中的搜索问题，首先想到 二分法 解决。
    public static int missingNumber2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m-1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int res = missingNumber2(nums);
        System.out.println(res);
    }
}
