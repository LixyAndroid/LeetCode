package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/7/30 22:50
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 */
public class SingleNumbers256 {
    //在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
    //继续位运算
    public int singleNumber(int[] nums) {
        int[] bitSum = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int bitMask = 1;
            //求每位与1 & 运算
            for (int j = 31; j >= 0; j--) {
                int bit = nums[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMask <<= 1;
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result += bitSum[i] % 3;
        }

        return result;
    }
}
