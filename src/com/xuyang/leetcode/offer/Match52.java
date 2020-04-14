package com.xuyang.leetcode.offer;

/**
 * @author Li Xuyang
 * @date 2020/4/4 15:16
 * 正则表达式匹配
 */
public class Match52 {

    /*
    请实现一个函数用来匹配包括'.'和'*'的正则表达式。
    模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
     在本题中，匹配是指字符串的所有字符匹配整个模式。
     例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配

     */

    //作对题目首先要读清题意：在本题中，匹配是指字符串的所有字符匹配整个模式。
    //
    //模式串中可能存在'.*'，它是贪婪匹配，在使整个表达式能得到匹配的前提下匹配尽可能多的字符。例如字符串"abcdeded"与模式"a.*d"匹配。
    //
    //按下一个字符是否是'*'分情况讨论，这个不难，但是要考虑全面有点难度。
    //递归
    public boolean match(char[] str, char[] pattern) {

        return machStr(str, 0, pattern, 0);

    }

    public boolean machStr(char[] str, int i, char[] pattern, int j) {

        //边界
        if (i == str.length && j == pattern.length) {//字符串和模式串都为空，
            return true;
        } else if (j == pattern.length) {//模式串为空
            return false;

        }

        //模式串下一个字符串是'*'
        boolean next = (j + 1 < pattern.length && pattern[j + 1] == '*');
        if (next) {
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])) {//要保证i<str.length,否则越界
                return machStr(str, i, pattern, j + 2) || machStr(str, i + 1, pattern, j);

            } else {
                return machStr(str, i, pattern, j + 2);
            }
        } else {
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])) {
                return machStr(str, i + 1, pattern, j + 1);
            } else {
                return false;
            }
        }

    }

    public static void main(String[] args) {
        char[] str = {'a','a','a'};
        char[] pattern = {'a','b','*','a','c','*','a'};
        Match52 match51 = new Match52();
        System.out.println(match51.match(str,pattern));
    }

}
