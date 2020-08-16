package com.xuyang.leetcode.offer2;

import java.util.Arrays;

/**
 * @author Li Xuyang
 * @date 2020/8/16 16:53
 * 剑指 Offer 45. 把数组排成最小的数
 */
public class MinNumber45 {
    //输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，
    // 打印能拼接出的所有数字中最小的一个。

    //想到自定义排序，把整体分成部分的思想
    //说明:
    //
    //输出结果可能非常大，所以你需要返回一个字符串而不是整数
    //拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        fastSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    private void fastSort(String[] strs, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = r;
        String temp = strs[i];
        while (i < j) {
            /*
            返回值是整型，它是先比较对应字符的大小(ASCII码顺序)，如果第一个字符和参数的第一个字符不等，结束比较，
            返回他们之间的差值，如果第一个字符和参数的第一个字符相等，则以第二个字符和参数的第二个字符做比较，以此类推,直至比较的字符或被比较的字符有一方结束。

                如果参数字符串等于此字符串，则返回值 0；
                如果此字符串小于字符串参数，则返回一个小于 0 的值；
                如果此字符串大于字符串参数，则返回一个大于 0 的值。
             */
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) {
                j--;
            }
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) {
                i++;
            }
            temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;

        }
        strs[i] = strs[l];
        strs[l] = temp;
        fastSort(strs, l, i - 1);
        fastSort(strs, i + 1, r);

    }

    public String minNumber2(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        //Arrays，帮忙排序
        Arrays.sort(strings, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

}
