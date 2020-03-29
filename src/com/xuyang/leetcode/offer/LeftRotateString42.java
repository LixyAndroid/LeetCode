package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/3/29 15:19
 * 左旋转字符串
 */
public class LeftRotateString42 {

    //左旋转字符串

    /*
    汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
    对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
    例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     */

    public static String leftRotateString(String str, int n) {

        StringBuilder temp = new StringBuilder();


        if (str==null||str.length()==0){
            return "";
        }

        for (int i = 0; i < n; i++) {
            temp.append(str.charAt(i));
        }


        str = str.substring(n) + temp.toString();

        return str;


    }

    public static void main(String[] args) {
        String str = "abcXYZdef";

        String res = leftRotateString(str, 3);

        System.out.println(res);

    }
}
