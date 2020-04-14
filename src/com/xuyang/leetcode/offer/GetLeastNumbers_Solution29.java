package com.xuyang.leetcode.offer;

import java.util.ArrayList;

/**
 * @author Li Xuyang
 * @date 2020/3/22 16:04
 * 最小的K个数
 */
public class GetLeastNumbers_Solution29 {


    //输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
    public static ArrayList<Integer> getLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        if (input.length == 0 || input.length < k) {
            return result;
        }

        //先加入前k个数，
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }

        //遍历后面input.length -k个数，有比这里面小的就替换

        for (int j = k; j < input.length; j++) {

            for (int i = 0; i < k; i++) {
                if (result.get(i) > input[j]) {

                    int temp = result.get(i);
                    result.set(i, input[j]);
                    input[j] = temp;

                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,12,32,43,546,65,343,656,234,665,23,65,234,656,234,656,234,654,6,67,4,78,65};
        ArrayList<Integer> result = getLeastNumbers_Solution(arr,5);
        System.out.println(result);
    }
}
