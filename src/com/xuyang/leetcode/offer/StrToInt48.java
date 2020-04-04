package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/4/4 13:43
 * 把字符串转换成整数
 */
public class StrToInt48 {


    /*
    题目描述
    将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
    数值为0或者字符串不是一个合法的数值则返回0
    输入描述:
    输入一个字符串,包括数字字母符号,可以为空
    输出描述:
    如果是合法的数值表达则返回该数字，否则返回0

     */
    public int strToInt(String str) {

        //trim() 方法用于删除字符串的头尾空白符。
        if (str == null || "".equals(str.trim())) {
            return 0;
        }
        str = str.trim();
        char[] arr = str.toCharArray();
        //while循环
        int i = 0;
        //用于正负
        int flag = 1;
        //结果
        int res = 0;

        //负号
        if (arr[i]=='-'){
            flag=-1;
        }

        //先判断第一位是不是正负位
        if (arr[i] == '+' || arr[i] == '-') {
            i++;
        }
        while (i < arr.length) {
            //是数字
            if (isNum(arr[i])) {
                //当前位的数字
                int cur = arr[i] - '0';
                if (flag == 1 && (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && cur > 7)) {
                    return 0;
                }

                if (flag == -1 && (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && cur > 8)) {
                    return 0;
                }
                res = res * 10 + cur;
                i++;

            } else {
                //不是数字
                return 0;
            }


        }


        return res * flag;


    }

    //写个方法判读是否是数字
    public boolean isNum(char c) {

        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        StrToInt48 strToInt48 = new StrToInt48();

        String str = "-131231231";

        System.out.println(strToInt48.strToInt(str));

    }

}
