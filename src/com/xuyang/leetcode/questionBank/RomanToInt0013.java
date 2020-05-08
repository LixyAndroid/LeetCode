package com.xuyang.leetcode.questionBank;

import java.util.HashMap;

/**
 * @author Li Xuyang
 * @date 2020/5/8 18:44
 * 罗马数字转整数
 */
public class RomanToInt0013 {

    //自己的办法
    public int romanToInt(String s) {

        //把阿拉伯数字与罗马数字可能出现的所有情况和对应关系，放在两个数组中
        //并且按照阿拉伯数字的大小降序排列，这就贪心选择思想
        int[] nums = {1000, 500, 100, 50, 10, 5, 1};
        char[] romans = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

        HashMap<Character, Integer> characterIntegerHashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            characterIntegerHashMap.put(romans[i], nums[i]);
        }

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1) {
                if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
                    res += 900;
                    i += 1;
                } else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
                    res += 400;
                    i += 1;
                } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
                    res += 90;
                    i += 1;
                } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
                    res += 40;
                    i += 1;
                } else if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
                    res += 9;
                    i += 1;
                } else if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
                    res += 4;
                    i += 1;
                } else {
                    res += characterIntegerHashMap.get(s.charAt(i));
                }
            } else {
                res += characterIntegerHashMap.get(s.charAt(i));

            }


        }

        return res;

    }

    //被人的办法
    /*
    在代码实现上，可以往后看多一位，对比当前位与后一位的大小关系，从而确定当前位是加还是减法。当没有下一位时，做加法即可。

也可保留当前位的值，当遍历到下一位的时，对比保留值与遍历位的大小关系，再确定保留值为加还是减。最后一位做加法即可。

     */

    public int romanToInt2(String s) {

        int sum =0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {

            int num = getValue(s.charAt(i));
            if (preNum<num){
                sum-=preNum;
            }else {
                sum+=preNum;
            }
            preNum=num;

        }
        sum+=preNum;
        return sum;

    }

    private int getValue(char ch) {
        switch (ch) {

            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:return 0;

        }
    }


    public static void main(String[] args) {
        RomanToInt0013 romanToInt0013 = new RomanToInt0013();

        String s = "MCM";
        int res = romanToInt0013.romanToInt2(s);
        System.out.println(res);

    }
}
