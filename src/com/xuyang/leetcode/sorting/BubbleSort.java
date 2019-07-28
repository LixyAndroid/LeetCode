package com.xuyang.leetcode.sorting;

/**
 * @author Li Xuyang
 * date  2019/7/25 21:02
 * <p>
 * 冒泡排序。核心是交换
 * 最坏情况复杂度和平均情况复杂度均为O(n²)
 * 最优O(n)
 */
public class BubbleSort {

    public static void bubble(int[] values) {
        boolean swapped;
        for (int i = 0; i < values.length - 1; i++) {

            swapped = false;

            for (int j = values.length - 1; j > i; j--) {

                //如果后者小于前者，这需要执行交换
                if (values[j] < values[j - 1]) {

                    //交换j，和j-1处的值
                    int temp = values[j];
                    values[j] = values[j - 1];
                    values[j - 1] = temp;

                    //交换完，设置swapped = true;

                    swapped = true;
                }

            }
            //swapped 为false的话，就说明。没进入交换，就说明排序完成，直接break;
            if (!swapped) {
                break;
            }

        }


    }


    public static void main(String[] args) {

        int[] values = {4, 89, 3, 8, 1, 45, 28, 34, 56, 7, 6, 17, 9, 41, 65, 21};
        System.out.print("排序前: ");

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

        //排序
        bubble(values);

        System.out.println("");
        System.out.print("排序后: ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

    }
}
