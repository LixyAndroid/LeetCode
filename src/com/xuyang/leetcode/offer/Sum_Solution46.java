package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/4/2 17:08
 */
public class Sum_Solution46 {
    public static int sumSolution(int n) {
        //n*(n+1)/2
        int sum = (int) (Math.pow(n,2)+n);
        return sum>>1;

    }



    public static int sumSolution2(int n) {


        //强行递归
        //当n=0时，sum=0，&&后面的就不会执行了，直接返回sum=0
        int sum = n;
        boolean flag = (sum>0)&&((sum+=sumSolution2(n-1))>0);
        return sum;

    }

    public static void main(String[] args) {
        System.out.println(sumSolution(20));
        System.out.println(sumSolution2(20));
    }
}
