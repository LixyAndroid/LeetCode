package com.xuyang.leetcode.offer2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li Xuyang
 * @date 2020/8/16 17:54
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 */
public class FindContinuousSequence257 {
    //输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
    //
    //序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
    //滑动窗口
    public int[][] findContinuousSequence(int target) {
        int i = 1;//滑动窗口的左边界
        int j = 1;//滑动窗口的右边界
        int sum = 0;
        List<int[]> resList = new ArrayList<>();
        while (i <= target / 2) {
            if (sum < target) {
                //右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                //左边界向右移动
                sum -= i;
                i++;
            } else {
                //记录结果
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                resList.add(arr);
                //左边界向右移动
                sum -= i;
                i++;
            }


        }

        return resList.toArray(new int[resList.size()][]);
    }
}
