package com.xuyang.leetcode.offer;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/4/4 14:46
 * 构建乘积数组
 */
public class Multiply50 {

    /*
    给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
    不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
     */

    //使用cur指向特定元素，给B赋值

    public static int[] multiply(int[] A) {
        if (A == null || A.length < 2) {
            return null;

        }

        int length = A.length;
        int[] B = new int[length];
        for (int i = 0; i < length; i++) {
            B[i] = 1;
        }

        for (int i = 1; i < length; i++) {
            B[0] *= A[i];
        }

        for (int i = 0; i < length - 1; i++) {
            B[length - 1] *= A[i];
        }


        int cur = 1;
        while (cur < length - 1) {

            for (int i = 0; i < cur; i++) {
                B[cur] *= A[i];

            }

            for (int j = cur + 1; j < length; j++) {
                B[cur] *= A[j];

            }
            cur++;


        }

        return B;


    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = new int[A.length];

        B = multiply(A);
        System.out.println(Arrays.toString(B));
    }
}
