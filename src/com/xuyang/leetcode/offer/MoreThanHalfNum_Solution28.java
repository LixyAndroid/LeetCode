package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/3/22 15:47
 * 数组中出现次数超过一半的数字
 */
public class MoreThanHalfNum_Solution28 {
    /*
    题目描述
    数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     */
    public static  int moreThanHalfNumSolution(int[] array) {

        if (array.length == 0) {
            return 0;
        }

        int times = 1;
        int num = array[0];
        for (int i = 0; i < array.length; i++) {

            if (num == array[i]) {
                times++;
            } else {
                times--;
                //减掉完了就换下个数字
                if (times == 0) {
                    num = array[i];
                    times = 1;
                }
            }


        }
        //说明抵消的超过了一半，则可以返回了
        if (times > 1) {
            return num;
        } else {
            return 0;

        }

    }

    public static void main(String[] args) {
        int[] array = {1,1,2,1,1,15,3,1,1,12};

        int result = moreThanHalfNumSolution(array);
        System.out.println(result);
    }
}
