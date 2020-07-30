package com.xuyang.leetcode.offer2;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/7/30 21:51
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 */
public class SingleNumbers56 {
    //要深刻理解位运算
    /*
    让我们先来考虑一个比较简单的问题：

如果除了一个数字以外，其他数字都出现了两次，那么如何找到出现一次的数字？

答案很简单：全员进行异或操作即可。考虑异或操作的性质：对于两个操作数的每一位，相同结果为 0，不同结果为 1。那么在计算过程中，
成对出现的数字的所有位会两两抵消为 0，最终得到的结果就是那个出现了一次的数字。

那么这一方法如何扩展到找出两个出现一次的数字呢？

如果我们可以把所有数字分成两组，使得：

两个只出现一次的数字在不同的组中；

相同的数字会被分到相同的组中。

那么对两个组分别进行异或操作，即可得到答案的两个数字。这是解决这个问题的关键。
     */
    /*
    算法
先对所有数字进行一次异或，得到两个出现一次的数字的异或值。

在异或结果中找到任意为 1 的位。

根据这一位对所有的数字进行分组。

在每个组内进行异或操作，得到两个数字。
     */
    public static int[] singleNumbers(int[] nums) {
        //用于将所有的数异或起来
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        //获得ret中最低位的1
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) == 0) {
                a ^= n;
            } else {
                b ^= n;
            }

        }
        return new int[]{a, b};

    }

    public static void main(String[] args) {
        int[] nums = {4,1,4,6};
        int[] res = singleNumbers(nums);
        System.out.println(Arrays.toString(res));
    }
}
