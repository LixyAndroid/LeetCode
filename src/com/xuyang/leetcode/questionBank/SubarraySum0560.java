package com.xuyang.leetcode.questionBank;

import java.util.HashMap;

/**
 * @author Li Xuyang
 * @date 2020/5/15 10:03
 * 和为K的子数组
 */
public class SubarraySum0560 {

    //给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。


    //注意负数,还有下个数是0的情况
    public static int subarraySum(int[] nums, int k) {
        int cnt = 0;
        int index=0;
        while (index<nums.length){

            int sum =0;
            for (int i = index; i < nums.length; i++) {
                sum+=nums[i];
                if (sum==k){
                    cnt+=1;
                }
            }
            index++;
        }
        return cnt;
    }


    //注意负数,还有下个数是0的情况，优化,使用hashmap,片段思想，要想到片段，利用containsKey（pre-k）
    public static int subarraySum2(int[] nums, int k) {
        int count = 0,pre =0;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {

            pre+=nums[i];
            if (map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }

        return count;

    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        int cnt= subarraySum2(nums,0);
        System.out.println(cnt);
    }
}
