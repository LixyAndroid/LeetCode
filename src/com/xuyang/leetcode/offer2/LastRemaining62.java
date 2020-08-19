package com.xuyang.leetcode.offer2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Li Xuyang
 * @date 2020/8/8 11:08
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 */
public class LastRemaining62 {
    //0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
    //
    //例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

    //迭代代替递归
    public static int lastRemaining(int n, int m) {
        int f = 0;
        for (int i = 2; i != n + 1; i++) {
            f = (m + f) % i;
        }
        return f;
    }

    //递归
    int lastRemaining2(int n, int m) {
        return f(n, m);
    }

    int f(int n, int m) {
        if (n == 1)
            return 0;
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    //模拟，好理解但时间超了
    public static int lastRemaining3(int n, int m) {

        if (n < 1 || m < 1) {
            return -1;
        }

        List<Integer> list = new LinkedList<>();
        //构建list
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int cur = -1;

        while (list.size() > 1) {

            for (int i = 0; i < m; i++) {
                cur++;

                //关键！
                if (cur == list.size()) {
                    cur = 0;
                }
            }
            list.remove(cur);
            //cur--的原因，因为新的list中cur指向了下一个元素，
            // 为了保证移动m个准确性，所以cur向前移动一位
            cur--;
        }

        return list.get(0);

    }


    public static void main(String[] args) {
        int res = lastRemaining3(5, 3);
        System.out.println(res);
    }
}
