package com.xuyang.leetcode.questionBank;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/9/22 10:04
 * 删除排序数组中的重复项
 */
public class RemoveDuplicates0026 {
    //给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
    //
    //不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
    //
    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        int i = 0;
        while (i < len) {
            int index = i;
            int temp = nums[i];
            while (index + 1 < len && nums[index + 1] == temp) {
                index++;
            }
            nums[cnt] = temp;
            cnt++;
            i = index + 1;

        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int res = removeDuplicates(nums);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));

    }
}
