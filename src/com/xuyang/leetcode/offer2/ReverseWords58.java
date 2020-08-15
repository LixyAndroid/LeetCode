package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/15 09:57
 * 剑指 Offer 58 - I. 翻转单词顺序
 */
public class ReverseWords58 {
    //输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
    // 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

    public String reverseWords(String s) {

        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder stringBuilder = new StringBuilder();
        //思路要清晰
        while (i >= 0) {

            while (i >= 0 && s.charAt(i) != ' ') {
                i--; //搜索首个空格
            }

            stringBuilder.append(s.substring(i + 1, j + 1) + " ");//添加单词

            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i; //j指向下个单词的尾字符

        }

        return stringBuilder.toString().trim();
    }

    public String reverseWords2(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) { //倒序遍历单词列表
            if (strs[i].equals(" ")) { //遇到空单词跳过
                continue;
            }
            res.append(strs[i] + " ");
        }
        return res.toString().trim();
    }


    public static void main(String[] args) {

        ReverseWords58 reverseWords58 = new ReverseWords58();
        String s = "the sky is blue.";
        String string = reverseWords58.reverseWords(s);
        System.out.println(string);

    }
}
