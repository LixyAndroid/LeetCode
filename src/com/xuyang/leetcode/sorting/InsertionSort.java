package com.xuyang.leetcode.sorting;

/**
 * @author Li Xuyang
 * date  2019/7/25 20:33
 *
 * 插入排序
 *
 */
public class InsertionSort {

    public static void insertion(int[] values){

        if (values.length <=1){
            return;
        }

        int j,insertValue;
        for (int i =1; i < values.length;i++){

            insertValue = values[i];
            j = i -1;
            //j位置上的值大于插入的值，就执行前移交换
            while (j>=0 && values[j]>insertValue){

                //前移
                values[j+1] = values[j];
                //j自减1
                j = j-1;

            }

            //取前面排序完的，第j后面的数作为插入值，进行和其他数字比较
            values[j+1] = insertValue;

        }



    }

    public static void main(String[] args) {

        int[] values = {4, 89, 3, 8, 81, 1, 45, 28, 34, 56, 7, 6, 17, 9, 41, 65, 21};
        System.out.print("排序前: ");

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

        //排序
        insertion(values);

        System.out.println("");
        System.out.print("排序后: ");
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + " ");
        }

    }


}
