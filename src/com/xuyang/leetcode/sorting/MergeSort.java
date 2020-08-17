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
 *  归并排序
 *  时间复杂度：O(nlogn)
 *  空间复杂度：O(N)
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

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;//中间索引

            //向左递归分解
            mergeSort(arr, left, mid, temp);

            //向右递归进行分解
            mergeSort(arr, mid + 1, right, temp);
            merge2(arr, left, mid, right, temp);
        }
    }

    private static void merge2(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//初始化i,左边有序序列的初始索引
        int j = mid + 1; //初始化j,右边有序序列的初始索引
        int t = 0; //指向temp数组的当前索引

        //（一）
        //先把左右两边（有序）的数据按照规则填充到temp数组
        //直到左右两边都是有序序列
        while (i <= mid && j <= right) {
            //如果左边有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，填充到temp数组
            //然后t++，i++
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }

        }

        //（二）
        //把剩余数据到一边的数据依次填充到temp
        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //(三)
        //将temp数组到元素拷贝到arr
        //注意，并不是每一次都是拷贝所有
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }

    }


    public static void main(String[] args) {

        int[] values = {4, 89, 3, 8, 81, 1, 45, 56, 7, 6, 17, 9, 41, 65, 21};
        System.out.print("排序前: ");

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }
        int temp[] = new int[values.length];//归并排序需要一个额外的空间


        //排序
        mergeSort(values, 0, values.length - 1,temp);

        System.out.println("");
        System.out.print("排序后: ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

    }

}
