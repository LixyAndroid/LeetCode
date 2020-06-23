package com.xuyang.leetcode.questionBank;

import org.w3c.dom.ls.LSOutput;

/**
 * @author Li Xuyang
 * @date 2020/6/23 22:28
 * 二进制求和
 */
public class AddBinary0067 {

    /*
    给你两个二进制字符串，返回它们的和（用二进制表示）。

    输入为 非空 字符串且只包含数字 1 和 0。
     */
    public static String addBinary(String a, String b) {

        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        StringBuilder res = new StringBuilder();
        int isCarry = 0;
        while (aLen >= 0 || bLen >= 0) {
            int aNum = aLen >= 0 ? Integer.parseInt(String.valueOf(a.charAt(aLen))) : 0;
            int bNum = bLen >= 0 ? Integer.parseInt(String.valueOf(b.charAt(bLen))) : 0;

            if (aNum==1){
                isCarry++;
            }
            if (bNum==1){
                isCarry++;
            }


            if(isCarry%2==1){
                res.append("1");
            }else{
                res.append("0");
            }
            isCarry/=2;

            aLen--;
            bLen--;

        }

        if (isCarry==1){
            res.append("1");
        }


        return res.reverse().toString();
    }

    //优化
    public String addBinary2(String a, String b) {
        int n = a.length();
        int m = b.length();
        //保证n是大的
        if(n<m){
            return addBinary2(b,a);
        }
        int length = Math.max(n,m);

        StringBuilder sb = new StringBuilder();

        int charindex = 0;
        int j = m - 1;
        for(int i = length-1;i>-1;--i){

            if(a.charAt(i) == '1'){
                charindex++;
            }
            if(j>-1&&b.charAt(j--) == '1'){
                charindex++;
            }

            if(charindex%2==1){
                sb.append("1");
            }else{
                sb.append("0");
            }
            charindex/=2;

        }

        if(charindex==1){
            sb.append("1");
        }

        sb.reverse();
        return sb.toString();



    }

    public static void main(String[] args) {
        String res = addBinary("1010", "1011");
        System.out.println(res);

        AddBinary0067 addBinary0067 = new AddBinary0067();
        String res2 = addBinary0067.addBinary2("1010", "1011");
        System.out.println(res);

    }
}
