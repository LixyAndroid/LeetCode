package com.xuyang.leetcode.sorting;

/**
 * @author Li Xuyang
 * @date 2020/8/17 09:35
 * 堆排序 O(nlogn)
 */
public class HeapSort {
    public static void heapSort(int[] arr) {
        int temp = 0;
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }


    }

    //将一个数组（二叉树），调整成一个大顶堆
    private static void adjustHeap(int[] arr, int i, int length) {
        //先取出当前元素的值，保存再临时变量
        int temp = arr[i];

        //开始调整
        for (int k = i * 2 + 1; k < length; k++) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++; //指向右结点
            }

            if (arr[k] > temp) {
                arr[i] = arr[k];//把较大的值赋给当前的结点
                i = k;//i指向k,继续循环比较
            } else {
                break;
            }
        }

        //for循环结束后，我们已经将以i为父结点的最大值，放再了最顶（局部）
        arr[i] = temp;//将temp放到调整后的位置

    }
}
