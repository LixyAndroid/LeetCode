package com.xuyang.leetcode.offer2;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/8/1 00:19
 * 剑指 Offer 40. 最小的k个数
 */
public class GetLeastNumbers40 {
    //输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
    //复杂度很高
    public static int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];

        //冒泡
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;

            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }

            }
            if (!swapped) {
                break;
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }

        return res;
    }


    public static int[] getLeastNumbers2(int[] arr, int k) {
        int[] res = new int[k];

        //系统自带
        Arrays.sort(arr);


        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }

        return res;
    }

    //快排
    public int[] getLeastNumbers3(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, lo, j - 1, k): quickSearch(nums, j + 1, hi, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v);
            while (--j >= lo && nums[j] > v);
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }


    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int[] res = getLeastNumbers(arr, 8);
        System.out.println(Arrays.toString(res));
    }
}
