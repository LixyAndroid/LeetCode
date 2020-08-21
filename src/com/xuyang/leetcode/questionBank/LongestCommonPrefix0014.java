package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/5/14 10:28
 * 最长公共前缀
 */
public class LongestCommonPrefix0014 {

    //编写一个函数来查找字符串数组中的最长公共前缀。
    //
    //如果不存在公共前缀，返回空字符串 ""。


    //    /*
//    首先，我们将描述一种查找一组字符串的最长公共前缀 LCP(S1....Sn)的简单方法
//
//    我们将会用到这样的结论： LCP(S1....Sn) = LCP（LCP(LCP(S1,S2),S3),...Sn）
//     */
//
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    //public int indexOf(int ch): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
    //
    //public int indexOf(int ch, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
    //
    //int indexOf(String str): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
    //
    //int indexOf(String str, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String res = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
            i += 1;
        }
        return res;
    }

    /*
     算法二：水平扫描
    算法

    想象数组的末尾有一个非常短的字符串，使用上述方法依旧会进行 S​ 次比较。优化这类情况的一种方法就是水平扫描。
    我们从前往后枚举字符串的每一列，先比较每个字符串相同列上的字符（即不同字符串相同下标的字符）然后再进行对下一列的比较。

    //好思想，肯定是从0索引到不重复的索引 所以用 String[]  的 substring，返回指定索引就好了
    //好方法！
     */
    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        //判断的时候只需要逐个判读字符，还有主要长度

        for (int i = 0; i < strs[0].length(); i++) {

            //定义需要的比较的字符 c
            char c = strs[0].charAt(i);

            for (int j = 0; j < strs.length; j++) {

                //i等于其中一个字符串的长度，就返回 或者找到了与前面有不同的字符,就也返回
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[j].substring(0, i);
                }

            }

        }

        return strs[0];

    }

    public static void main(String[] args) {

        String[] strs = {"flower", "flow", "flight"};

        String[] strs1 = {"a"};
        String[] strs2 = {"flow", "flower"};

        String[] strs4 = {"aca", "cba"};

        String[] strs5 = {"a", "b"};
        String res = longestCommonPrefix(strs);
        System.out.println(res);
    }
}
