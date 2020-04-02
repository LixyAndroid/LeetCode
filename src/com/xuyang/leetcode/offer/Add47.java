package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/4/2 17:28
 */
public class Add47 {

    //写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。


    //位异或运算（^）,位异或哦
    public static int add(int num1, int num2) {
        int result = 0;
        int carry = 0;
        do {
            result = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = result;
            num2 = carry;
        } while (carry != 0);

        return result;


    }

    public static void main(String[] args) {
        System.out.println(add(10,221));
    }
}
