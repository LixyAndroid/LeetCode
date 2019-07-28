package com.xuyang.leetcode.sorting;

/**
 * @author Li Xuyang
 * date  2019/7/27 17:36
 * <p>
 * 快速排序是冒泡排序的升级版
 * 分而治之
 * 1、先从数列中取出一个数作为基准数
 * 2、分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边
 * 3、再对左右区间重复第二步，直到各区间只有一个数
 * 概括来说为 挖坑填数+分治法
 */
public class QuickSort {

    public static void quick(int[] values, int low, int high) {
        if (low < high) {

            //下一次子集分区时的分隔点序号index
            int index = partition(values, low, high);
            quick(values, low, index - 1);
            quick(values, index + 1, high);
        }

    }

    private static int partition(int[] values, int low, int high) {

        int pivot = values[high];
        int i = (low - 1);

        for (int j = low; j < high - 1; j++) {

            //如果j处的值，小于等于最高位处的值 就执行交换，把i处的值和j处交换
            if (values[j] <= pivot) {
                i++;

                //i和j处的值交换，
                int temp = values[i];
                values[i] = values[j];
                values[j] = temp;

            }

        }


        i++;
        int temp = values[i];
        values[i] = values[high];
        values[high] = temp;


        return i;

    }

    public static void main(String[] args) {

        int[] values = {4, 89, 3, 8, 81, 1, 45, 28, 34, 56, 7, 6, 17, 9, 65, 21};
        System.out.print("排序前: ");

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

        //排序
        quick(values, 0, values.length - 1);

        System.out.println("");
        System.out.print("排序后: ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

    }

}
