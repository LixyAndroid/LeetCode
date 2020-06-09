package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/6/9 21:20
 * 把数字翻译成字符串
 */
public class TranslateNum0046 {

    /*
    给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。
    请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     */
    //动态规划，滚动数组优化动态规划
    public static int translateNum(int num) {
        String src = String.valueOf(num);
        int p =0,q=0,r=1;
        for (int i = 0; i < src.length(); i++) {

            p = q;
            q = r;

            r=0;
            r+=q;
            if (i==0){
                continue;
            }
            String pre = src.substring(i-1,i+1);
            if (pre.compareTo("25")<=0&& pre.compareTo("10") >= 0){
                r+=p;
            }
        }
        return r;

    }

    public static void main(String[] args) {
        int num = 12258;
        int res = translateNum(num);
        System.out.println(res);
    }

}
