package com.xuyang.leetcode.questionBank;

import java.util.ArrayList;

/**
 * @author Li Xuyang
 * @date 2020/5/1 12:43
 * 回文数
 */
public class IsPalindrome0009 {

    //判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    public boolean isPalindrome(int x) {

        if (x<0){
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int n = x;
        while (n>0){
            int temp = n%10;
            list.add(temp);
            n /=10;
        }
        int res =0;
        for (int i = 0; i < list.size(); i++) {
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && list.get(i) > 7) {
                return false;
            }
            res = res * 10 + list.get(i);

        }

        return x==res;


    }
    public boolean isPalindrome2(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x<0||(x%10==0&&x!=0)){
            return false;
        }

        int revertedNumber = 0;

        while (x>revertedNumber){
            revertedNumber = revertedNumber*10+x%10;
            //这里巧妙
            x/=10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。

        return x==revertedNumber||x==revertedNumber/10;

    }

        public static void main(String[] args) {

        IsPalindrome0009 isPalindrome0009 = new IsPalindrome0009();
        boolean res = isPalindrome0009.isPalindrome2(12321);

        System.out.println(res);
    }
}
