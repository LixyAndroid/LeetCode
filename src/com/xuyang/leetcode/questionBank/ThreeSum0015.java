package com.xuyang.leetcode.questionBank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Li Xuyang
 * @date 2020/5/24 21:39
 * 三数之和
 */
public class ThreeSum0015 {

    //给你一个包含 n 个整数的数组 nums，
    // 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
    // 请你找出所有满足条件且不重复的三元组。
    //
    //注意：答案中不可以包含重复的三元组。


    //先排序，然后利用双指针法，注意去重复
    public List<List<Integer>> threeSum(int[] nums) {
        //排序，不自己去排，找个专门排序的人来排
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                //左右指针
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0) {
                        //Arrays.asList 将参数转换成数组
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;

                    } else if (sum > 0) {
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;
                    } else {
                        while (l < r && nums[l] == nums[l + 1]) {//去重
                            l++;
                        }
                        l++;
                    }
                }

            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> Sum = new ThreeSum0015().threeSum(nums);

        System.out.println(Sum);

    }
}
