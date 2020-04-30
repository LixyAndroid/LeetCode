package com.xuyang.leetcode.myAtoi;

/**
 * @author Li Xuyang
 * date  2019/7/23 15:41
 * 字符串转换整数

 */
public class Solution {

    /*
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     */

    public static int myAtoi(String str) {

        int i = 0, j = 0;
        boolean negative = false;
        for (i = 0; i < str.length(); i++) {
            //String.charAt方法可以求出指定位置的字符

            //字符‘0’对应的ASCII码是48，48对应的十六进制数就是0x30，
            //字符‘9’对应的ASCII码是57，48对应的十六进制数就是0x39，
            // 比较的是ASCII值，起初思路是对的
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                break;
            } else if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                negative = str.charAt(i) == '-';
                i++;
                break;
            } else if (str.charAt(i) != ' ') {
                return 0;
            }
        }
        for (j = i; j < str.length(); j++) {
            if (str.charAt(j) < '0' || '9' < str.charAt(j)) {
                break;
            }
        }
        //定义初始返回值
        int ret = 0;

        //就是要找到i,j的区间的数字字符串，然后转换成数字
        String num = str.substring(i, j);
        for (int x = 0; x < num.length(); x++) {
            int cur = num.charAt(x) - '0';
            if (negative) {
                //判断溢出
                if (ret < Integer.MIN_VALUE / 10 || ret == Integer.MIN_VALUE / 10 && cur > 8) {
                    return Integer.MIN_VALUE;
                }
                //相当于负号
                ret = ret * 10 - cur;
            } else {
                if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && cur > 7) {
                    return Integer.MAX_VALUE;
                }
                ret = ret * 10 + cur;
            }
        }
        return ret;
    }


    public static void main(String[] args) {

        String str = "  -55113  74*1+with words";
        String str1 = "  571a";
        String str2 = "  -57 1  ";

        System.out.println(myAtoi(str));
        System.out.println(myAtoi(str1));
        System.out.println(myAtoi(str2));

    }


}
