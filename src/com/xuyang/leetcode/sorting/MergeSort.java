package com.xuyang.leetcode.sorting;

/**
 * @author Li Xuyang
 * date  2019/7/27 19:58
 * 归并排序
 * 就基于分而治之策略的排序算法而言， 归并排序是目前最高效的算法之一
 * 最坏，平均和最优的情况复杂度均为O（nlog(n)）其最快情况的复杂度优于快速排序
 * 归并操作的工作原理如下：
 * 第一步：申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * 第二步：设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 第三步：比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * 重复步骤3直到某一指针超出序列尾
 * 将另一序列剩下的所有元素直接复制到合并序列尾
 */
public class MergeSort {

    public static void merge(int[] values, int left, int right) {

        if (left == right)//说明集合为空或者只有一个元素
            return;

        if (left < right) {
            int middle = (left + right) / 2;

            merge(values, left, middle);
            merge(values, middle + 1, right);

            int[] temp = new int[values.length];

            for (int n = left; n <= right; n++) {
                temp[n] = values[n];
            }

            int index1 = left;
            int index2 = middle + 1;

            //对子集排序
            for (int n = left; n <= right; n++) {
                if (index1 == middle + 1) {
                    values[n] = temp[index2++];
                } else if (index2 > right) {
                    values[n] = temp[index1++];
                } else if (temp[index1] < temp[index2]) {
                    values[n] = temp[index1++];
                } else {
                    values[n] = temp[index2++];
                }

            }

        }

    }

    public static void main(String[] args) {

        int[] values = {4, 89, 3, 8, 81, 1, 45, 56, 7, 6, 17, 9, 41, 65, 21};
        System.out.print("排序前: ");

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

        //排序
        merge(values, 0, values.length - 1);

        System.out.println("");
        System.out.print("排序后: ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

    }

}
