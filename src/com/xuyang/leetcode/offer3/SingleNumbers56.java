package com.xuyang.leetcode.offer3;

/**
 * @author Li Xuyang
 * @date 2020/9/23 21:38
 */
public class SingleNumbers56 {
    /*
    先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
    在异或结果中找到任意为 1 的位。
    根据这一位对所有的数字进行分组。
    在每个组内进行异或操作，得到两个数字。
     */
    //一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
    public int[] singleNumbers(int[] nums) {
        //用于将所有的数字异或起来
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }

        //获得ret 中最低位的1
        //关键
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }

        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
