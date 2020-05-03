package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/5/3 17:08
 * 最大子序和
 */
public class MaxSubArray0053 {

    //贪心
    public int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(curSum, maxSum);
        }

        return maxSum;
    }

    //动态规划
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int res =nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i-1]>0){
                nums[i] += nums[i-1];
            }
            res = Math.max(res,nums[i]);
        }
        return res;
    }
}
