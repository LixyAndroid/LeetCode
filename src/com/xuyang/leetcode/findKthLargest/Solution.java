package com.xuyang.leetcode.findKthLargest;

/**
 * @author Li Xuyang
 * date  2019/7/28 11:24
 * <p>
 * 数组中的第K个最大元素
 */
public class Solution {


    /*
    思路：
    先用排序算法，进行排序，再找到第K大的元素
    第K大的数的索引为 values.length - k 数组为从小到大排序的话
     */

    public static int findKthLargest(int[] nums, int k) {

        int[] values = bubbleSort(nums);

        return values[values.length - k];

    }

    //冒泡排序
    private static int[] bubbleSort(int[] values) {

        boolean swapped;

        for (int i = 0; i < values.length - 1; i++) {
            swapped = false;

            for (int j = values.length - 1; j > i; j--) {
                //后面的小于前面的，就交换
                if (values[j] < values[j - 1]) {

                    int temp = values[j];
                    values[j] = values[j - 1];
                    values[j - 1] = temp;
                    swapped = true;
                }
            }

            if (swapped == false) {
                break;
            }

        }
        return values;


    }


    public static void main(String[] args) {
        int[] values = {4, 89, 3, 8, 1, 45, 28, 34, 56, 7, 6, 17, 9, 41, 65, 21};
        System.out.print("排序前: ");

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

        //排序
        values = bubbleSort(values);

        System.out.println();
        System.out.print("排序后: ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }


        System.out.println();
        int result = findKthLargest(values, 5);

        System.out.println(result);
    }

}
