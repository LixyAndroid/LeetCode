package com.xuyang.leetcode.offer2;

/**
 * @author Li Xuyang
 * @date 2020/8/4 21:47
 * 剑指 Offer 67. 把字符串转换成整数
 */
public class StrToInt67 {
    /*
    写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

     */
    public int strToInt(String str) {
        //这种一定要考虑越界
        if (str.equals("")) {
            return 0;
        }

        int index = 0;
        boolean flag = true;
        while (str.charAt(index) == ' ') {
            index++;
            if (str.length() <= index) {
                return 0;
            }
        }

        if (str.length() <= index) {
            return 0;
        }

        if (str.charAt(index) == '-') {
            flag = false;
            index += 1;
        } else if (str.charAt(index) == '+') {
            index += 1;
        }

        //已经除去空格，-号,判断第一位是不是不是数字
        if (str.length() > index) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                return 0;
            }
        } else {
            return 0;
        }


        int res = 0;

        for (int i = index; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            if (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < digit)) {
                // 说明溢出
                if (flag) {//正数
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            } else {
                res = res * 10 + digit;
            }

        }
        return flag ? res : -res;
    }

    //优化 但是超过方法1
    public int strToInt2(String str) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int index = 0, sign = 1, length = str.length();
        if (length == 0) {
            return 0;
        }
        while (str.charAt(index) == ' ') {
            if (++index == length) {
                return 0;
            }
        }
        //正负号
        if (str.charAt(index) == '-') {
            sign = -1;
            index += 1;
        } else if (str.charAt(index) == '+') {
            index += 1;
        }


        for (int i = index; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            //Integer.MAX_VALUE % 10 可以换成7
            if (res > bndry || (res == bndry && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
        }
        return res * sign;
    }

    public int strToInt3(String str) {
        //String类 trim() 方法用于删除字符串的头尾空白符
        char[] c = str.trim().toCharArray();
        if (c.length == 0) {
            return 0;
        }
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int index = 0, sign = 1;

        //正负号
        if (c[index] == '-') {
            sign = -1;
            index += 1;
        } else if (c[index] == '+') {
            index += 1;
        }


        for (int i = index; i < c.length; i++) {
            int digit = c[i] - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            //Integer.MAX_VALUE % 10 可以换成7
            if (res > bndry || (res == bndry && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
        }
        return res * sign;
    }

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
        StrToInt67 strToInt67 = new StrToInt67();
        String str = "  -23";
        int res = strToInt67.strToInt3(str);
        System.out.println(res);


    }
}
