package com.xuyang.leetcode.questionBank;

/**
 * @author Li Xuyang
 * @date 2020/5/2 11:45
 * 正则表达式匹配
 */
public class IsMatch0010 {
    public boolean isMatch(String s, String p) {
        char[] schar = s.toCharArray();
        char[] pchar = p.toCharArray();
        return machStr(schar, 0, pchar, 0);

    }

    public boolean machStr(char[] str, int i, char[] pattern, int j) {
        //边界
        if (i == str.length && j == pattern.length) { //字符串和模式都为空，或者到了最后
            return true;
        } else if (j == pattern.length) { //字符串为空，或者匹配到最后了
            return false;
        }

        //模式串下一个字符串是*
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

    /*
    方法 1：回溯
想法

如果没有星号（正则表达式中的 * ），问题会很简单——我们只需要从左到右检查匹配串 s 是否能匹配模式串 p 的每一个字符。

当模式串中有星号时，我们需要检查匹配串 s 中的不同后缀，以判断它们是否能匹配模式串剩余的部分。一个直观的解法就是用回溯的方法来体现这种关系。

如果模式串中有星号，它会出现在第二个位置，即 pattern[1] 。
这种情况下，我们可以直接忽略模式串中这一部分，或者删除匹配串的第一个字符，前提是它能够匹配模式串当前位置字符，即pattern[0] 。
如果两种操作中有任何一种使得剩下的字符串能匹配，那么初始时，匹配串和模式串就可以被匹配。

     */

    public boolean isMatch2(String text, String pattern) {

        if (pattern.isEmpty()) {
            return text.isEmpty();
        }

        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

}
