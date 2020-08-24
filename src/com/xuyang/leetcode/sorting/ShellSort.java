package com.xuyang.leetcode.sorting;

/**
 * @author Li Xuyang
 * @date 2020/8/24 23:22
 * 希尔排序
 */
public class ShellSort {

    static void shellSort(int[] arr) {
        //interval是增量
        for (int interval = arr.length / 2; interval > 0; interval = interval / 2) {
            for (int i = interval; i < arr.length; i++) {
                int target = arr[i];
                int j = i - interval;
                while (j > -1 && target < arr[j]) {
                    arr[j + interval] = arr[j];
                    j -= interval;
                }
                arr[j + interval] = target;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 7, 8, 31, 23, 56, 34};
        shellSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
