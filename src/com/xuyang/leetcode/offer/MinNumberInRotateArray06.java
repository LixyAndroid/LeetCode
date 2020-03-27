package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * date  2019/9/10 20:12
 * 旋转数组的最小数字
 */
public class MinNumberInRotateArray06 {


    //* 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    // * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    // * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    // * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

    /*
     * 思路
     * 找到最小数字通常只需遍历一遍数组就可以，时间复杂度是O(n)。
     * 这里肯定不能这样做，因为没有利用到旋转数组的特性，根据观察，最小值其实是数组前后两部分的分界，而这两部分都是有序的，可以利用二分查找的思想进行处理。
     */
    public static int minNumberInRotateArray(int[] array) {

        if (array.length == 0) {
            return 0;
        }

        int low = 0;
        int high = array.length - 1;
        int mid = low;
        while (array[low] >= array[high]) {
            //左边比右边下标为1 时候 找到目标值
            if (high - low == 1) {
                mid = high;
                break;
            }
            mid = (low + high) / 2;
            if (array[mid] >= array[low]) {     //当中间值比左边值大的时候 说明最小值还在后面
                low = mid;
            } else if (array[mid] <= array[high]) {     //当中间值比左边值小的时候 说明最小值在前面
                high = mid;
            }
        }
        return array[mid];

//        //依次比较蛮干法
//
//        if (array == null || array.length == 0) {
//            return 0;
//        }
//        int result = array[0];
//        for (int i = 0; i < array.length - 1; i++) {
//            if (array[i + 1] < array[i]) {
//                result = array[i + 1];
//                break;
//            }
//        }
//        return result;
    }


    public static void main(String[] args) {

        int[] array = {3, 4, 5, 1, 2};
        int result = minNumberInRotateArray(array);

        System.out.println(result);

    }
}


