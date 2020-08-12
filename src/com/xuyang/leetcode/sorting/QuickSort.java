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

    public static void quickSort(int[] values, int low, int high) {

        int l = low; //左下标
        int r = high; //右下标
        //pivot 中轴值
        int pivot = values[(low + high) / 2];
        int temp = 0; //临时变量，作为交换时使用
        //while循环的目的是让比pivot 值小放到左边
        //比pivot 值大放到右边
        while (l < r) {
            //在pivot的左边一直找,找到大于等于pivot值,才退出
            while (values[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找,找到小于等于pivot值,才退出
            while (values[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                break;
            }

            //交换
            temp = values[l];
            values[l] = values[r];
            values[r] = temp;

            //如果交换完后，发现这个values[l] == pivot值 相等 r--， 前移
            if (values[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个values[r] == pivot值 相等 l++， 后移
            if (values[r] == pivot) {
                l += 1;
            }
        }

        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (low < r) {
            quickSort(values, low, r);
        }
        //向右递归
        if (high > l) {
            quickSort(values, l, high);
        }

    }


    public static void main(String[] args) {

        int[] values = {4, 89, 3, 8, 81, 1, 45, 28, 34, 56, 7, 6, 17, 9, 65, 21};
        System.out.print("排序前: ");

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

        //排序
        quickSort(values, 0, values.length - 1);

        System.out.println("");
        System.out.print("排序后: ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

    }

}
