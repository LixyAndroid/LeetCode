package com.xuyang.leetcode.questionBank;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/8/23 22:05
 * 最长上升子序列
 */
public class LengthOfLIS0300 {
    //给定一个无序的整数数组，找到其中最长上升子序列的长度。
    //动态规划
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);

        }
        return res;
    }

    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            //通过二分查找递增的序列的元素
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = num;
            if (res == j) {
                res++;
            }

        }
        return res;
    }
}
