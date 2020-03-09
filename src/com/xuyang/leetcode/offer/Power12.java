package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/3/9 14:52
 * 数值的整数次方
 */
public class Power12 {

    //给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
    //保证base和exponent不同时为0
    //方法1：牛客答题解法，暴力法
    public static double power(double base, int exponent) {


        double result = 1.0;
        if (base == 0) {
            return 0;
        }

        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                result = result * base;
            }
        } else if (exponent == 0) {
            return 1;
        } else if (exponent < 0) {
            base = 1 / base;
            for (int i = 0; i < Math.abs(exponent); i++) {
                result = result * base;
            }

        }

        return result;
    }

    //方法2：位运算
    public static double power2(double base, int exponent) {

        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return exponent;
        }

        boolean isNegative = exponent < 0;
        int absExponent = Math.abs(exponent);
        double result = 1.0;

        while (absExponent != 0) {

            //如果exponent最右位是1，将当前base累乘到result
            if ((absExponent & 1) == 1) {

                result *= base;

            }

            base *= base;
            //右移一位
            absExponent >>= 1;
            //除以2也是一样到
            // absExponent/=2;

        }
        return isNegative ? (1 / result) : result;
    }

    //方法3：java提供到API实现
    public static double power3(double base, int exponent) {


        return Math.pow(base, exponent);
    }


    //二分思想
    public static double power4(double base, int exponent) {
        if (base == 0.0 && exponent < 0)
            throw new IllegalArgumentException("Illegal Input!");
        double result = nonnativePower4(base, Math.abs(exponent));
        return exponent < 0 ? (1.0 / result) : result;
    }

    private static double nonnativePower4(double base, int exponent) {
        //exponent > 0
        //递归终止条件
        if (exponent == 0)
            return 1.0;
        if (exponent == 1)
            return base;


        double result = power4(base, exponent >> 1);
        result *= result;
        //余数为1时
        if ((exponent & 0x1) == 1)
            result *= base;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(5.21, -5));
        System.out.println(power2(5.21, 5));
        System.out.println(power3(5.21, -5));
        System.out.println(power4(5.21, 5));


    }

}
