package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/6/2 21:40
 * 求1+2+…+n
 */
public class SumNums0064 {

    /*
    求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */
    //递归1
    public int sumNums(int n) {
        return helper(n);

    }

    public int helper(int n) {
        if (n == 1) {
            return 1;
        }
        return n + helper(n - 1);
    }

    //递归2
    public int sumNums2(int n) {

        //巧妙，当n>0为false 则就不执行后面的，所以也就求出和
        boolean flag = n > 0 && (n += sumNums2(n - 1)) > 0;
        return n;

    }

    public static void main(String[] args) {
        SumNums0064 sumNums0064 = new SumNums0064();

        int res = sumNums0064.sumNums(2);
        System.out.println(res);
    }

}
