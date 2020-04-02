package com.xuyang.leetcode.isPowerOfTwo;

/**
 * @author Li Xuyang
 * @date 2020/3/30 17:10
 */
public class Solution {

    //暴力是偶数的话 除法
    public static boolean isPowerOfTwo(int n){

        //注意0不是
        if (n==0){
            return false;
        }

        //当是偶数当时候 n = n/2;
        while (n%2==0){
            n=n/2;
        }

        //最后是2^n次方的话，n==1了
        //否则就是比1大的奇数
        return n==1;
    }

    //按照位数与
    public boolean isPowerOfTwo2(int n) {

        if (n<=0){
            return false;
        }

        return (n&(n-1))==0;
    }



    public static void main(String[] args) {

        boolean res = isPowerOfTwo(10);
        System.out.println(res);
    }
}
