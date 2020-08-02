package com.xuyang.leetcode.offer2;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/8/2 14:39
 * 剑指 Offer 17. 打印从1到最大的n位数
 */
public class PrintNumbers17 {
    //输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

    public static int[] printNumbers(int n) {

        int len = 1;
        for (int i = 0; i < n; i++) {
            len *= 10;
        }

        int[] res = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            res[i] = i + 1;
        }
        return res;

    }

    public static void main(String[] args) {

        int[] res = printNumbers(3);
        System.out.println(Arrays.toString(res));
    }
}
