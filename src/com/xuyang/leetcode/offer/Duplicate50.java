package com.xuyang.leetcode.offer;

import java.util.HashMap;

/**
 * @author Li Xuyang
 * @date 2020/4/4 14:27
 * 数组中重复的数字
 */
public class Duplicate50 {
    //HashMap

    /*

    在一个长度为n的数组里的所有数字都在0到n-1的范围内。
    数组中某些数字是重复的，但不知道有几个数字是重复的。
    也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

     */

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {

        if (length<2){
            return false;
        }

        boolean flag = false;

        HashMap<Integer, Integer> map = new HashMap();

        int cur = 0;
        while (!false) {


            if (map.containsKey(numbers[cur])) {
                flag = true;
                duplication[0] = numbers[cur];
                break;
            } else {
                map.put(numbers[cur], cur);
            }
            cur++;
            if (cur > length - 1) {
                break;
            }


        }

        return flag;

    }

    public static void main(String[] args) {
        Duplicate50 duplicate49  = new Duplicate50();
        int[] nums = {2,3,1,0,2,5,3};
        int[] duplication = {0,0};
        boolean res = duplicate49.duplicate(nums,nums.length,duplication);
        System.out.println(res);
        if (res){
            System.out.println(duplication[0]);
        }

    }
}
