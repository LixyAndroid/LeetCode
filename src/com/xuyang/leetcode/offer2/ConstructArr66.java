package com.xuyang.leetcode.offer2;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/8/14 22:42
 * 剑指 Offer 66. 构建乘积数组
 */
public class ConstructArr66 {
    /*
    给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
    其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。

     */
    //时间超了
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int temp = 1;
            int left = i - 1;
            int right = i + 1;
            while (left >= 0) {
                temp *= a[left];
                left--;
            }

            while (right < a.length) {
                temp *= a[right];
                right++;
            }

            res[i] = temp;

        }
        return res;
    }

    /*
    算法流程：
        1,初始化：数组 B ，其中 B[0] = 1；辅助变量 tmp = 1 ；
        2,计算 B[i] 的 下三角 各元素的乘积，直接乘入 B[i] ；
        3,计算 B[i] 的 上三角 各元素的乘积，记为 tmp ，并乘入B[i] ；
        4,返回 B。
     */
    public int[] constructArr2(int[] a) {
        if (a.length == 0) {
            return new int[0];
        }
        int[] res = new int[a.length];
        res[0] = 1;
        int temp = 1;
        for (int i = 1; i < a.length; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }

        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            res[i] *= temp;
        }

        return res;
    }

    public static void main(String[] args) {
        ConstructArr66 constructArr66 = new ConstructArr66();
        int[] a = {1, 2, 3, 4, 5};
        int[] res = constructArr66.constructArr(a);
        System.out.println(Arrays.toString(res));

    }
}
