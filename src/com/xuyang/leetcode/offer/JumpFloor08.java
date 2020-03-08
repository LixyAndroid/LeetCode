package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/3/8 17:38
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor08 {

    public static int jumpFloor(int target) {


        //递归实现，不太好
        if (target == 0 || target == 1) {
            return 1;
        } else {
            return jumpFloor(target - 1) + jumpFloor(target - 2);
        }


    }


    //非递归
    public static int jumpFloor2(int target) {


        int per1 = 1, per2 = 2;
        if (target < 2) {
            return target;
        } else {

            for (int i = 3; i < target + 1; i++) {
                int temp = per1 + per2;
                per1 = per2;
                per2 = temp;
            }


        }

        return per2;


    }

    public static void main(String[] args) {

        System.out.println(jumpFloor2(10));
    }
}
