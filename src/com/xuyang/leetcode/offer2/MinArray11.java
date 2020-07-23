package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/7/22 22:36
 * 剑指 Offer 11. 旋转数组的最小数字
 */

public class MinArray11 {
    //主要复习二分查找
    public static int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,3,1,1,1,1,1,2,2};
        int res = minArray(nums);
        System.out.println(res);
    }
}
