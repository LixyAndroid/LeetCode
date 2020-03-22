package com.xuyang.leetcode.offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Li Xuyang
 * @date 2020/3/22 15:14
 * 字符串的排列
 */
public class Permutation26 {



    //题目描述
    //输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

    /*

        //String的用法：
        //java中String是只读的，没有办法进行变换，因此需要使用StringBuilder。
        String.length() //获取字符串的长度
        String.charAt(i) //获取第i个字符的内容
        String.subString(start)   //获取[start,最后）的字符串
        String.subString(start,end) //获取[start,end）中的字符串
        char[] c = iniString.toCharArray() //将字符串转为char数组来进行改变字符内容
        String.equal() //判断两个字符串是否相等

        //StringBuilder的用法：
        除了String中支持的方法外，StringBuilder支持字符的增、删、改。
        stringBuilder.append("we");  //添加we在词尾
        stringBuilder.insert(0,"we");//在0的位置加入后面的内容
        stringBuilder.delete(0,1);  //删除[0,1)的数据
        stringBuilder.deleteCharAt(0);
        stringBuilder.setCharAt(0,'p'); //在某一个独特位置设置字符
        char c = stringBuilder.charAt(i);//查询某个位置上的字符
        System.out.println(stringBuilder);
        new String(stringBuilder);//用stringBuilder来初始化String
     */

    public ArrayList<String> permutation(String str) {

        StringBuilder stringBuilder = new StringBuilder(str);
        ArrayList<String> result = permutationHelp(stringBuilder);
        return result;

    }

    public ArrayList<String> permutationHelp(StringBuilder str) {

        ArrayList<String> resultList = new ArrayList<>();
        if (str.length() == 1) {
            resultList.add(str.toString());
        } else {
            for (int i = 0; i < str.length(); i++) {
                //?
                if (i == 0 || str.charAt(i) != str.charAt(0)) {
                    char temp = str.charAt(i);
                    str.setCharAt(i, str.charAt(0));
                    str.setCharAt(0, temp);

                    ArrayList<String> stringArrayList = permutationHelp(new StringBuilder(str.substring(1)));

                    for (int j = 0; j < stringArrayList.size(); j++) {

                        resultList.add(str.substring(0, 1) + stringArrayList.get(j));
                    }

                    //用完还是要放回去的
                    temp = str.charAt(0);
                    str.setCharAt(0, str.charAt(i));
                    str.setCharAt(i, temp);
                }
            }
            Collections.sort(resultList);
        }
        return resultList;


    }


    /**
     * 题目：输入一个字符串，打印出该字符事中字符的所有排列。例如输入字符串abc。
     * 则打印出由字符a、b、c 所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
     *
     * @param chars 待排序的字符数组
     */
    public static void permutation(char[] chars) {
        // 输入较验
        if (chars == null || chars.length < 1) {
            return;
        }
        // 进行排列操作
        permutation(chars, 0);
    }

    /**
     * 求字符数组的排列
     *
     * @param chars 待排列的字符串
     * @param begin 当前处理的位置
     */
    public static void permutation(char[] chars, int begin) {
        // 如果是最后一个元素了，就输出排列结果
        if (chars.length - 1 == begin) {
            System.out.print(new String(chars) + " ");
        } else {
            char tmp;
            // 对当前还未处理的字符串进行处理，每个字符都可以作为当前处理位置的元素
            for (int i = begin; i < chars.length; i++) {
                // 下面是交换元素的位置
                tmp = chars[begin];
                chars[begin] = chars[i];
                chars[i] = tmp;

                // 处理下一个位置
                permutation(chars, begin + 1);
            }
        }
    }


    public static void main(String[] args) {
        String str = "abcd";
        Permutation26 permutation26 = new Permutation26();
        ArrayList<String> strings = permutation26.permutation(str);
        System.out.println(strings);

        char[] c1 = {'a', 'b', 'c'};
        permutation(c1);

    }


}
