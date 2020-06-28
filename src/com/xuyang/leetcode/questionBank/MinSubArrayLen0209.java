package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/6/28 22:31
 * 长度最小的子数组
 */
public class MinSubArrayLen0209 {

    /*
    给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
    如果不存在符合条件的连续子数组，返回 0。
     */
    //双指针
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;

            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
