package com.xuyang.leetcode.questionBank;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/9/19 11:01
 * 三个数的最大乘积
 */
public class MaximumProduct628 {
    /*
    我们将数组进行升序排序，如果数组中所有的元素都是非负数，那么答案即为最后三个元素的乘积。

如果数组中出现了负数，那么我们还需要考虑乘积中包含负数的情况，显然选择最小的两个负数和最大的一个正数是最优的，即为前两个元素与最后一个元素的乘积。

上述两个结果中的较大值就是答案。注意我们可以不用判断数组中到底有没有正数，0 或者负数，因为上述两个结果实际上已经包含了所有情况，最大值一定在其中。
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }

    /*
    方法二：线性扫描
    在方法一中，我们实际上只要求出数组中最大的三个数以及最小的两个数，因此我们可以不用排序，用线性扫描直接得出这五个数。
     */
    public int maximumProduct2(int[] nums) {
        int min1 = Integer.MIN_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n : nums) {
            //min1最小
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) { // n lies between min1 and min2
                min2 = n;
            }

            //max1 最大
            if (n >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);

    }
}
