package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/10 23:08
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
public class Search53 {
    //统计一个数字在排序数组中出现的次数。
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] == target) {
                break;
            }

        }
        if (left >= right) {
            return 0;
        }
        int res = left + (right - left) / 2;
        int cut = 0;
        while (res >= 0 && nums[res] == target) { //左
            cut++;
            res--;
        }
        int res2 = 1 + left + (right - left) / 2;

        while (res2 < nums.length && nums[res2] == target) {//右
            cut++;
            res2++;
        }

        return cut;
    }

    public int search2(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }


    public static void main(String[] args) {
        Search53 search53 = new Search53();
        int[] nums = {5, 7, 7,8, 8, 8, 10};
        int result = search53.search(nums, 8);
        System.out.println(result);

    }
}
