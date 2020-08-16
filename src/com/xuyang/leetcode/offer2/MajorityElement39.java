package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/16 16:38
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 */
public class MajorityElement39 {
    /*
    数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */
    public static int majorityElement(int[] nums) {
        int x = 0;
        int votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;

        }
        return x;
    }

    //不存在但时候，返回0
    public static int majorityElement2(int[] nums) {
        int x = 0;
        int votes = 0;
        int count = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;

        }
        //验证x是否为众数
        for (int num : nums) {
            if (num == x) {
                count++;
            }
        }


        return count > nums.length / 2 ? x : 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int res = majorityElement(nums);
        System.out.println(res);
    }
}
