package com.xuyang.leetcode.sorting;

/**
 * @author Li Xuyang
 * date  2019/7/25 20:13
 * 复习排序算法
 * 选择排序
 * 选择排序可描述为一种原地比较的算法
 */
public class SelectionSort {

    public static void selction(int[] values) {

        //若需要排序的数组长度 <= 1 直接返回，不需要下述判断
        if (values.length <= 1) {
            return;
        }

        int j, minIndex;
        for (int i = 0; i < values.length - 1; i++) {

            minIndex = i;
            for (j = i + 1; j < values.length; j++) {

                //如果有更小的值，就把此值的索引j赋值给minIndex
                if (values[j] < values[minIndex]) {

                    minIndex = j;
                }
            }

            int temp = values[minIndex];
            //最小值索引位置上的数，等于第i个位置上的数 ,此时最小值索引处已经不是最小值，而是原来i处交换过去的
            //需要在进行一次循环判断，赋值操作
            values[minIndex] = values[i];

            //交换
            values[i] = temp;


        }

    }


    public static void main(String[] args) {

        int[] values = {4, 89, 3, 8, 81, 1, 45, 28, 34, 56, 7, 6, 17, 9, 41, 65, 21};
        System.out.print("排序前: ");

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

        //排序
        selction(values);

        System.out.println("");
        System.out.print("排序后: ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

    }
}
