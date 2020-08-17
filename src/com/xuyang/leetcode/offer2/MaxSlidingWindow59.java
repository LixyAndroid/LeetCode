package com.xuyang.leetcode.offer2;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Li Xuyang
 * @date 2020/8/5 23:51
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 */
public class MaxSlidingWindow59 {
    //给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int index = 0;

        while (index < len) {
            int curMax = Integer.MIN_VALUE;
            for (int i = index; i < k + index; i++) {
                curMax = Math.max(curMax, nums[i]);
            }
            res[index] = curMax;
            index++;

        }
        return res;
    }

    //双端队列 deque
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0 || k == 0) { //判空
            return new int[0];
        }
        //保持队首的元素最大
        Deque<Integer> deque = new LinkedList<>();
        //返回的数组
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) { //未形成窗口
            //队尾
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) { //形成窗口后
            if (deque.peekFirst() == nums[i - k]) {//无用的那个，就是上次已经用过了
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,-4,2,4,6};
        int[] res = maxSlidingWindow2(nums, 3);
        System.out.println(Arrays.toString(res));
    }
}
