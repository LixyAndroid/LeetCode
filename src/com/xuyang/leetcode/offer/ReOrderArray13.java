package com.xuyang.leetcode.offer;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/3/9 21:20
 * 调整数组顺序使奇数位于偶数前面
 */
public class ReOrderArray13 {

    //输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    // 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
    // 并保证奇数和奇数，偶数和偶数之间的相对位置不变。

    public static void reOrderArray(int[] array) {
        //采用交换法,有点类似冒泡法

        //记录已经放好位置的k的个数
        int k = 0;

        for (int i = 0; i < array.length; i++) {

            //当有奇数的时候进入，k只记录第几次进入，而j=i，表示第几个数，若j=8,k=5,这表示 下标为6 ，7 的是偶数，就需要交换
            //
            if (array[i] % 2 == 1) {

                int j = i;

                //会把while 部分执行完，才执行后面的语句，如k++
                while (j > k) {

                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    j--;
                }

                k++;
            }

        }
    }

    //对上个方法对优化版
    public static void reOrderArray2(int[] array) {
        int m = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                //取到待插入到奇数
                int tmp = array[i];
                int j = i;
                //移动
                while (j > m) {
                    //将j-1处到值赋值给j,相当于对偶数进行后移，j>m多少就移动几次，
                    array[j] = array[j - 1];
                    j--;
                }
                //再将j+1赋值给m,array[j]放判断出来的奇数
                m = j + 1;
                array[j] = tmp;
            }
        }
    }


    /*
    思路，把原数组分成一个奇数组一个偶数组，再按顺序复制回去，这样，只需要遍历两次原数组即可。（一次读出，一次写入）
    空间效率下降，因为额外有两个数组用于记录，但时间效率较好。
     */
    public static void reOrderArray3(int[] array) {


        //所以此时，这两个array长度都==原array长度,所以需要oddLength，evenLength记录其有意义值的真实长度
        //也可先遍历原数组，确定奇偶数的个数再建立奇偶数组，但要多遍历一次。
        //奇数数组
        int[] arrayOdd = new int[array.length];
        //偶数数组
        int[] arrayEven = new int[array.length];

        //遍历
        int counter = 0;
        //奇数的个数，偶数的个数
        int counterOdd = 0, counterEven = 0;

        while (counter <array.length){

            if (array[counter]%2 ==0){
                //偶数
                arrayEven[counterEven] = array[counter];
                counterEven++;

            }else {
                //奇数
                arrayOdd[counterOdd] = array[counter];
                counterOdd++;

            }
            counter++;

        }
        for (int i = 0; i <counterOdd ; i++) {
            array[i] = arrayOdd[i];
        }

        for (int j = 0; j < counterEven; j++) {
            array[j+counterOdd] = arrayEven[j];
        }

    }


    /*
    i++往前走碰到偶数停下来，j = i+1
    若 a[j]为偶数，j++前进，直到碰到奇数
    a[j]对应的奇数插到a[i]位置，j经过的j-i个偶数依次后移
    如果j==len-1时还没碰到奇数，证明i和j之间都为偶数了，完成整个移动
     */
    public static void reOrderArray4(int[] array) {
      if (array.length<=1){
          return;
      }

      int i=0;
      while (i<array.length){
        int j = i+1;
        if (isOddNumber(array[i])){ // a[i]为偶数，j前进，直到替换

            while (isOddNumber(array[j])){ // j为偶数，前进

                if (j == array.length-1){ // i为偶数，j也为偶数，一直后移到了末尾，证明后面都是偶数
                    return;
                }

                j++;

            }
            //此时j为奇数
            int count = j-i;
            int temp = array[i];
            array[i] = array[j];

            while (count>1){
                array[i+count] = array[i+count-1]; //数组后移
                count--;
            }
            array[i+1] = temp;

        }
          i++;
      }


    }


    //判读是不是偶数
    public static boolean isOddNumber(int val) {
        if (val % 2 == 0) {
            return true;
        }
        return false;
    }


        //个人感觉方法2好，代码简练，也易懂
    public static void main(String[] args) {

        int[] arr = {1, 2, 10, 3, 4, 4, -6, 2, 4, 5, 8};
        //reOrderArray(arr);
       // reOrderArray2(arr);
       // reOrderArray3(arr);
        reOrderArray4(arr);


        System.out.println(Arrays.toString(arr));
    }
}
