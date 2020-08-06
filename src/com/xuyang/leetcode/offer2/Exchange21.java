package com.xuyang.leetcode.offer2;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/8/6 21:47
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class Exchange21 {
    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    // 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
    public static int[] exchange(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            //这种循环 注意越界，一定要注意！！！
            while (nums[left] % 2 != 0 && left < nums.length - 1) {
                left++;
            }
            //这种循环 注意越界，一定要注意！！！
            while (nums[right] % 2 == 0 && right > 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            left += 1;
            right -= 1;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 8};
        int[] res = exchange(nums);
        System.out.println(Arrays.toString(res));
    }
}
