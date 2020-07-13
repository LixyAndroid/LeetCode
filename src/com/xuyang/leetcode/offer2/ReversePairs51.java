package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/7/13 22:05
 * 数组中的逆序对
 */
public class ReversePairs51 {

    // 超过时间限制
    public static int reversePairs(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] > nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /*
    「归并排序」是分治思想的典型应用，它包含这样三个步骤：

    分解： 待排序的区间为 [l, r]，令 m=(l+r)/2，我们把 [l, r] 分成 [l, m] 和 [m + 1, r]
    解决： 使用归并排序递归地排序两个子序列
    合并： 把两个已经排好序的子序列 [l, m] 和 [m+1,r] 合并起来
    在待排序序列长度为 1 的时候，递归开始「回升」，因为我们默认长度为 1 的序列是排好序的。
    */
    public static int reversePairs2(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        //拷贝数据，不修改原始数组
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        //辅助数组
        int[] temp = new int[len];

        return reversePairs2(copy, 0, len - 1, temp);
    }

    /**
     * nums[left..right]计算逆序对的个数并且排序
     *
     * @param nums
     * @param left
     * @param right
     * @param temp
     * @return
     */
    private static int reversePairs2(int[] nums, int left, int right, int[] temp) {
        //递归先想递归终止条件
        if (left == right) {
            return 0;
        }
        //著名bug,整型溢出
        int mid = left + (right - left) / 2;
        int leftPairs = reversePairs2(nums, left, mid, temp);
        int rightPairs = reversePairs2(nums, mid + 1, right, temp);

        if (nums[mid] <= nums[mid + 1]) {
            return leftPairs + rightPairs;
        }
        int crossPairs = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + crossPairs;

    }

    /**
     * nums[left .. mid]有序，nums[mid+1..right]有序
     *
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @param temp
     * @return
     */
    private static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {

        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                //计算逆序
                count += (mid - i + 1);
            }
        }

        return count;

    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 5, 1};
        int res = reversePairs2(nums);
        System.out.println(res);
    }
}
