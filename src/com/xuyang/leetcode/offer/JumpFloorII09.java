package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/3/8 21:42
 */
public class JumpFloorII09 {

    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

    public static int jumpFloorII(int target){

        //左移需要判断输入是否合法，可通过测试用例
      //  return target <= 0 ? 0 : 1<<(target-1);

        //不需要判断，而且可以计算大数
        return (int)Math.pow(2,target-1);


    }

    public static void main(String[] args) {
        System.out.println(jumpFloorII(10));
    }

}
