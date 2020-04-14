package com.xuyang.leetcode.offer;

import java.util.ArrayList;

/**
 * @author Li Xuyang
 * @date 2020/3/29 15:32
 * 翻转单词顺序列
 */
public class ReverseSentence44 {

    /*
    牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
    同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
    例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
    正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     */

    //我觉得是判题的bug
    public static String reverseSentence(String str) {


        if (str.length() <2) {
            return str;
        }

        StringBuilder resBuilder = new StringBuilder();
        String[] strSplit = str.split(" ");


        for (int i = strSplit.length - 1; i >= 0; i--) {

            if (i > 0) {
                resBuilder.append(strSplit[i] + " ");
            } else {
                resBuilder.append(strSplit[0]);
            }


        }


        return resBuilder.toString();


    }


    public static String reverseSentence2(String str) {

        if(str.length()<=0){
            return "";
        }
        //反转整个句子
        StringBuffer st1=new StringBuffer(str);
        st1.reverse();
        //存放结果
        StringBuffer result=new StringBuffer();
        int j=0;
        //标记空格数
        int blankNum=0;
        for(int i=0;i<st1.length();i++){
            //1、当有空格，且没有到达最后一个单词时
            if(st1.charAt(i)==' '&&(i!=st1.length()-1)){
                blankNum++;
                StringBuffer st2=new StringBuffer(st1.substring(j,i));
                result.append(st2.reverse().toString()).append(" ");
                j=i+1;
            }
            //2、当有空格，且到达最后一个单词时
            if(blankNum!=0&&i==(st1.length()-1)){
                StringBuffer st3=new StringBuffer(st1.substring(j,i+1));
                result.append(st3.reverse());
            }
        }
        //空格数为0时，直接返回原字符串
        if(blankNum==0){
            return str;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "student. a am I";
        String res = reverseSentence(s);
        System.out.println(res);
        String s1 = " ";

        String res1 = reverseSentence(s1);
        System.out.println(res1);

        String res2 = reverseSentence2(s1);
        System.out.println(res2);


    }
}
