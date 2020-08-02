package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/2 14:30
 * 剑指 Offer 58 - II. 左旋转字符串
 */
public class ReverseLeftWords58 {
    //字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
    // 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

    public static String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        //0~n 不包括n
        String left = s.substring(0, n);
        //n到最后
        String right = s.substring(n);
        stringBuilder.append(right);
        stringBuilder.append(left);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String res = reverseLeftWords(s,k);
        System.out.println(res);
    }
}
