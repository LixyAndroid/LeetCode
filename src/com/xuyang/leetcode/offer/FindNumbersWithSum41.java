package com.xuyang.leetcode.offer;

import java.util.ArrayList;

/**
 * @author Li Xuyang
 * @date 2020/3/28 22:45
 * 和为S的两个数字
 */
public class FindNumbersWithSum41 {


    //硬着头皮解题就是了

    /*

    输入一个递增排序的数组和一个数字S，在数组中查找两个数，
    使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
    输出描述:
    对应每个测试案例，输出两个数，小的先输出。
     */


    public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {


        ArrayList<Integer> res = new ArrayList<>();

        //边界条件
        if (array == null || array.length <= 1) {
            return res;
        }
        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length; j++) {

                if (array[i] + array[j] == sum) {
                    res.add(array[i]);
                    res.add(array[j]);

                }
            }

        }


        //这个好
        while (res.size() > 2) {
            res.remove(2);
        }


        //不推荐，不过也是可以的

        /*

        if (res.size()>2){
            ArrayList<Integer> res3 = new ArrayList<>();
            res3.add(res.get(0));
            res3.add(res.get(1));

            return res3;

        }

         */


        return res;

    }



    //这种更好点，复杂度很低
    public ArrayList<Integer> findNumbersWithSum2(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        //边界条件
        if (array == null || array.length <= 1) {
            return result;
        }
        int smallIndex = 0;
        int bigIndex = array.length - 1;
        while (smallIndex < bigIndex) {
            //如果相等就放进去
            if ((array[smallIndex] + array[bigIndex]) == sum) {
                result.add(array[smallIndex]);
                result.add(array[bigIndex]);
                //最外层的乘积最小，别被题目误导，只要有就可以返回了
                break;
            } else if ((array[smallIndex] + array[bigIndex]) < sum) {
                smallIndex++;
            } else {
                bigIndex--;
            }
        }
        return result;
    }
}
