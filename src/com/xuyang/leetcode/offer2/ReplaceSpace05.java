package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/6 20:08
 * 剑指 Offer 05. 替换空格
 */
public class ReplaceSpace05 {
    //请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
    public static String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    //3倍的s的长度
    public static String replaceSpace2(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                //array[size++] 相当与array[size]；size++；
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

    //调用自带api
    public static String replaceSpace3(String s) {
        return s.replace(" ", "%20");
    }

    public static void main(String[] args) {
        String s = "a";
        String res = replaceSpace2(s);
        System.out.println(res);
    }
}
